/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytask.taskmavenweb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.Map;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import org.json.simple.JSONArray;
import org.springframework.jdbc.core.SingleColumnRowMapper;

/**
 *
 * @author Subhan-apollo
 */
public class DBQueries {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //private DataSource dataSource;
    private SimpleJdbcCall jdbcCall;

//    public void setDataSource(SimpleJdbcCall jdbcCall) {
//        //this.dataSource = dataSource;
//        this.jdbcCall = new SimpleJdbcCall(dataSource).
//                withProcedureName("INSERT_STUDENT");
//    }
    public void create(Stdnt s) {

//        Map<String, Object> inParamMap = new HashMap<String, Object>();
//        inParamMap.put("P_NAME", s.getName());
//        inParamMap.put("P_FACULTY", s.getFaculty());
//        inParamMap.put("P_REG", s.getReg());
//        inParamMap.put("P_GENDER", s.getGender());
//        inParamMap.put("P_AGE", s.getAge());
//        SqlParameterSource in = new MapSqlParameterSource(inParamMap);
//        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
//                .withProcedureName("INSERT_STUDENT");
//
//        Map<String, Object> inParamMap = new HashMap<String, Object>();
//        inParamMap.put("P_NAME", s.getName());
//        inParamMap.put("P_FACULTY", s.getFaculty());
//        inParamMap.put("P_REG", s.getReg());
//        inParamMap.put("P_GENDER", s.getGender());
//        inParamMap.put("P_AGE", s.getAge());
//        SqlParameterSource in = new MapSqlParameterSource(inParamMap);
//
//        Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
//        System.out.println(simpleJdbcCallResult);
        StoredProcedureCall storedProcedureCall = new StoredProcedureCall(jdbcTemplate, "INSERT_STUDENT");

//        SqlParameter idparam = new SqlParameter("id", Types.INTEGER);
        SqlInOutParameter outParam = new SqlInOutParameter("P_NAME", Types.VARCHAR);
        SqlInOutParameter outParam1 = new SqlInOutParameter("P_FACULTY", Types.VARCHAR);
        SqlInOutParameter outParam2 = new SqlInOutParameter("P_REG", Types.VARCHAR);
        SqlInOutParameter outParam3 = new SqlInOutParameter("P_GENDER", Types.VARCHAR);
        SqlInOutParameter outParam4 = new SqlInOutParameter("P_AGE", Types.VARCHAR);

        SqlParameter[] paramArray = {outParam, outParam1, outParam2, outParam3, outParam4};

        storedProcedureCall.setParameters(paramArray);
        storedProcedureCall.compile();

        // Call stored procedure
        Map storedProcResult = storedProcedureCall.execute(s.getName(), s.getFaculty(), s.getReg(), s.getGender(), s.getAge());
        System.out.println("Result: " + storedProcResult);

//        jdbcCall.execute(in);
//        
//        SqlParameterSource in = new MapSqlParameterSource().
//                                addValue("P_NAME", s.getName());
//        SqlParameterSource in1 = new MapSqlParameterSource().addValue("P_Faculty", s.getFaculty());
//        
//        Map<String, Object> out = jdbcCall.execute(in, in1);
//        int num = (int) out.get("P_OUT");
//        return num;
//      JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
//      String SQL = "insert into Student (name, faculty, reg, gender, age) values (?, ?, ?, ?, ?)";
//
//      jdbcTemplateObject.update( SQL, s.getName(), s.getFaculty(), s.getReg(), s.getGender(), s.getAge());
        // System.out.println("Created Record Name = " + name + " Age = " + age);
        // return;
    }

    public Stdnt getStudent(Integer id) {
        SqlParameterSource in = new MapSqlParameterSource().
                addValue("in_id", id);
        Map<String, Object> out = jdbcCall.execute(in);

        Stdnt student = new Stdnt();
        student.setId(id);
        student.setName((String) out.get("out_name"));
        student.setFaculty((String) out.get("out_faculty"));
        student.setReg((String) out.get("out_reg"));
        student.setGender((String) out.get("out_gender"));
        student.setAge((String) out.get("out_age"));

        return student;
    }

    // TRYING to get Data from DB through Stored Procedure
    public List<Stdnt> listStudents() {
        String SQL = "select * from Student";
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate();
        List<Stdnt> students = jdbcTemplateObject.query(SQL, new RowMapper<Stdnt>() {
            public Stdnt mapRow(ResultSet rs, int rowNum) throws SQLException {
                Stdnt student = new Stdnt();

                student.setName(rs.getString("name"));
                student.setFaculty(rs.getString("faculty"));
                student.setReg(rs.getString("reg"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getString("age"));
                student.setId(rs.getInt("id"));
                return student;
            }
        });
        return students;
    }

    public void saveOrUpdate(Stdnt s) {

        String sql = "INSERT INTO STUDENT(name,faculty,reg,gender,age) values(?,?,?,?,?)";

        jdbcTemplate.update(sql, s.getName(), s.getFaculty(), s.getReg(), s.getGender(), s.getAge());
    }

    public void delete(int id) {
        String sql = "DELETE FROM STUDENT WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }

//    public void edit(Stdnt d, int id){
////        String name =d.getName();
////        String sql = "UPDATE STUDENT SET name= '" + name + "' WHERE id = ?";
////        jdbcTemplate.update(sql, id);
//
//          String sql = "SELECT NAME FROM STUDENT WHERE ID = '" + id + "'";
//          d.setName(sql);
//          
//          saveOrUpdate(d);
//          
//    }
    public Stdnt get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // gets data from DB without Stored Procedure
    public List<Stdnt> list() {
        String sql = "SELECT * from STUDENT";
        return jdbcTemplate.query(sql, new RowMapper<Stdnt>() {
            public Stdnt mapRow(ResultSet rs, int row) throws SQLException {
                Stdnt s = new Stdnt();

                s.setName(rs.getString(1));
                s.setFaculty(rs.getString(2));
                s.setReg(rs.getString(3));
                s.setGender(rs.getString(4));
                s.setAge(rs.getString(5));
                s.setId(rs.getInt(6));
                return s;
            }
        });
    }

    public List<Stdnt> list2(int id) {
        String sql = "SELECT * from STUDENT WHERE ID = " + id;
        return jdbcTemplate.query(sql, new RowMapper<Stdnt>() {
            public Stdnt mapRow(ResultSet rs, int row) throws SQLException {
                Stdnt s = new Stdnt();

                s.setName(rs.getString(1));
                s.setFaculty(rs.getString(2));
                s.setReg(rs.getString(3));
                s.setGender(rs.getString(4));
                s.setAge(rs.getString(5));
                s.setId(rs.getInt(6));
                return s;
            }
        });
    }

    public Stdnt findByStuID(int id) {
        String sql = "SELECT * FROM STUDENT WHERE ID = ?";
        Stdnt stu = (Stdnt) jdbcTemplate.queryForObject(
                sql, new Object[]{id}, new RowMapper<Stdnt>() {
            public Stdnt mapRow(ResultSet rs, int rowNum) throws SQLException {
                Stdnt s = new Stdnt();
                s.setName(rs.getString(1));
                s.setFaculty(rs.getString(2));
                s.setReg(rs.getString(3));
                s.setGender(rs.getString(4));
                s.setAge(rs.getString(5));
                s.setId(rs.getInt(6));
                System.out.println("ID: " + s.getId() + " Name: " + s.getName());
                return s;
            }
        }
        );
        return stu;
    }
//    public String getStu(){
//         return jdbcTemplate.query("SELECT Name FROM STUDENT where rownum=1 ", new ResultSetExtractor<String>() {
//            @Override
//            public String extractData(ResultSet rs) throws SQLException, DataAccessException {
//                String stuData = "";
//                while (rs.next()) {
//                    stuData = rs.getString("Name");
//                }
//                return stuData;
//            }
//        });
//        
//    }
//    
//    public int save(Stdnt p) {
//        String sql
//                = "insert into Student(name,faculty,reg,gender,age) values('" + p.getName() + "'  ," + p.getFaculty() + "  ,'" + p.getReg() + " ,'" + p.getGender() + " ,'" + p.getAge() + "'  )";
//
//        return jdbcTemplate.update(sql);
//    }
//
//    public int update(Stdnt p) {
//        String sql = "update Student set name='" + p.getName() + "', faculty=" + p.getFaculty() + ", reg=" + p.getReg() + ", gender=" + p.getGender() + ",age='" + p.getAge() + "' where id=" + p.getId() + "";
//        return jdbcTemplate.update(sql);
//    }
//
//    public int delete(int id) {
//        String sql = "delete from Student where id=" + id + "";
//        return jdbcTemplate.update(sql);
//    }

    public List<Map<String, Object>> dbData() {

        String sql = "SELECT DISTINCT CITY from CITIES";
        return jdbcTemplate.queryForList(sql, new SingleColumnRowMapper(String.class) {
            public String mapRow(ResultSet rs, int row) throws SQLException {
                JSONArray jsonArr = new JSONArray();
                String toReturn = "";
                while (rs.next()) {
                    jsonArr.add(rs.getString("CITY"));
                }
//                City c = new City();
//                c.setCity(rs.getString(1));
                toReturn = jsonArr.toJSONString();
                return toReturn;
            }
        });
    }

    public List<Map<String, Object>> dbData2(String val) {
        String sql = "Select SUB_CITY from CITIES where CITY ='" + val + "'";
        return jdbcTemplate.queryForList(sql, new SingleColumnRowMapper(String.class) {
            public String mapRow(ResultSet rs, int row) throws SQLException {
//                City c = new City();
//                c.setCity(rs.getString(2));
//                return c;
                JSONArray jsonArr = new JSONArray();
                String toReturn = "";
                while (rs.next()) {
                    jsonArr.add(rs.getString("SUB_CITY"));
                }
                toReturn = jsonArr.toJSONString();
                return toReturn;
            }
        });
    }
}
