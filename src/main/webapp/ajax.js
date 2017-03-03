///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//$(function () {
//    $("#_btn").click(function () {
//        getData();
//    });
//
//});
//
//function getData() {
//    $.ajax({
//        type: 'GET',
//        url: 'spring.htm',
//        data: {
//            action: 'getData'
//        },
//        success: function (data) {
//            alert(data);
//        }
//    });
//}



/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    getCityData();
    $("#_dropbox1").on('change', function () {
        var valDropBox = $(this).val();
//        alert(valDropBox);
//        console.log(valDropBox);
        getSubCityData(valDropBox);
    });
});


function getCityData(valDB) {
    $.post('City', {action: 'getCityData'}).done(function (data) {
        console.log(data);
        var obj = eval('(' + data.trim() + ')');
        var len = obj.length;
        var opt = '';
        for (var i = 0; i < len; i++) {
            opt += "<option value='" + obj[i] + "'>" + obj[i] + "</option>";
        }
        $("#_dropbox1").empty().append(opt);
    });
}

function getSubCityData(valDB) {
    $.post('City', {action: 'getSubCityData', dropDown2: valDB}).done(function (data) {
        console.log(data);
        var obj = eval('(' + data.trim() + ')');
        var len = obj.length;
        var opt = '';
        for (var i = 0; i < len; i++) {
            opt += "<option value='" + obj[i] + "'>" + obj[i] + "</option>";
        }
        $("#_dropbox2").empty().append(opt);
    });
}