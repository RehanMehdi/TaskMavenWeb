/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytask.taskmavenweb;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

/**
 *
 * @author Subhan-apollo
 */
public class StoredProcedureCall extends StoredProcedure {

    public StoredProcedureCall(JdbcTemplate jdbcTemplate, String spName) {
        super(jdbcTemplate, spName);
        setFunction(false);

    }
}
