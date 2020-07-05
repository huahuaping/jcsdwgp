/*更新课程信息*/
function courseupdate(row) {

    /*判断页面中是否存在id="dd"元素，若存在则进行删除*/

    if ($("#dd") != null) {

        $("#dd").remove();

    }

    /*在页面中id="tab"的元素中添加一个id="dd"的div元素*/

    $("#tab").append("<div id='dd'></div>");

    /*以页面中的id="dd"的元素作为对话框的内容*/

    $('#dd').dialog({

        title: '更新课程信息',//对话框的标题

        width: 300,//对话框的宽度

        closed: false,

        cache: false,//不允许有缓冲

        modal: true,//采用模式，即必须关闭对话框后才能做别的操作

        buttons: [{ //为对话框添加底部按钮

            text: '保存',

            handler: function () {

                $('#ff').form('submit', {

                    url: "course/updateByPrimaryKeySelective",

                    onSubmit: function () {

                        //在这里编写表单字段验证

                    },

                    success: function (data) {

                        $('#dd').dialog("close");//关闭当前添加窗口

                        $('#dg').datagrid("reload");//重新装入表格的内容

                    }

                });


            }

        }, {

            text: '关闭',

            handler: function () {

                $('#dd').dialog("close");

            }

        }]

    });

    //修改课程安排表单
    var str = ' <form id="ff" method="post">\n' +

        '        <table>\n' +

        '            <tr>\n' +

        '                <td><input type="hidden" id="id" name="id" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>课程代码</td>\n' +

        '                <td><input type="text" id="code" name="code" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>课程名称</td>\n' +

        '                <td><input type="text" id="name" name="name" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>课时</td>\n' +

        '                <td><input type="text" id="period" name="period" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>课程类型</td>\n' +

        '                <td><input type="text" id="Nature" name="nature" /> </td>\n' +

        '            </tr>\n' +

        '        </table>\n' +

        '    </form>';

    //把表单添加到对话框中

    $("#dd").html(str);

    $('#ff').form('load', row[0]);//为表单加载数据。


}
/*添加课程信息*/
function courseinsert() {

    /*判断页面中是否存在id="dd"元素，若存在则进行删除*/

    if ($("#dd") != null) {

        $("#dd").remove();

    }

    /*在页面中id="tab"的元素中添加一个id="dd"的div元素*/

    $("#tab").append("<div id='dd'></div>");

    /*以页面中的id="dd"的元素作为对话框的内容*/

    $('#dd').dialog({

        title: '添加课程信息',//对话框的标题

        width: 300,//对话框的宽度

        closed: false,

        cache: false,//不允许有缓冲

        modal: true,//采用模式，即必须关闭对话框后才能做别的操作

        buttons: [{ //为对话框添加底部按钮

            text: '保存',

            handler: function () {

                $('#ff').form('submit', {

                    url: "course/insertSelective",

                    onSubmit: function () {

                        //在这里编写表单字段验证

                    },

                    success: function (data) {

                        $('#dd').dialog("close");//关闭当前添加窗口

                        $('#dg').datagrid("reload");//重新装入表格的内容

                    }

                });


            }

        }, {

            text: '关闭',

            handler: function () {

                $('#dd').dialog("close");

            }

        }]

    });

    //创建添加课程信息表单

    var str = ' <form id="ff" method="post">\n' +

        '        <table>\n' +

        '            <tr>\n' +

        '                <td>课程代码</td>\n' +

        '                <td><input type="text" id="code" name="code" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>课程名称</td>\n' +

        '                <td><input type="text" id="name" name="name" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>课时</td>\n' +

        '                <td><input type="text" id="period" name="period" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>课程类型</td>\n' +

        '                <td><input type="text" id="Nature" name="nature" /> </td>\n' +

        '            </tr>\n' +

        '        </table>\n' +

        '    </form>';

    //把表单添加到对话框中

    $("#dd").html(str);

}
/*删除课程信息*/
function deletecourse(id) {
        $.ajax({
            url: 'course/deleteByPrimaryKey',
            type: 'POST',
            data:'id='+id,
            success:function () {
                $('#dg').datagrid("reload");//重新装入表格的内容
            }
        });
}
/*初始化表格*/
function initcourse() {

    /*判断页面中是否存在id等于dg的元素，若存在则进行删除*/

    if ($("#dg") != null) {

        $("#dg").remove(); //删除id="dg"的元素

    }

    $("#tab").empty();//把页面中id="tab"的元素内容清空

    /*在页面中id="tab"元素中添加一个id="dg"的div元素*/

    $("#tab").append("<div id='dg'></div>");

    /*下面采用jquery easyui的datagrie控制进行显示管理员的列表*/

    $('#dg').datagrid({

        //后台处理程序的地址

        url: 'course/listAll',

        pagination: true,//显示分页工具

        pageNumber: 1,//表示显示第几页，第一页

        pageSize: 10,//表示每页显示的记录个数

        pageList: [10, 20, 30, 40, 50],//第一页显示记录个数列表
        toolbar: [{//显示工具栏

            text: '添加',

            iconCls: 'icon-add',

            handler: function () {

                courseinsert();

            }

        }, '-', {

            text: '更新',

            iconCls: 'icon-edit',

            handler: function () {

                var row = $('#dg').datagrid("getSelections");//获取用户选择的数据行

                if (row && row.length > 0) {

                    if (row.length > 1) {

                        alert("一次只能更新一条记录");

                        return false;

                    } else {

                        courseupdate(row);

                    }

                } else {

                    alert("请选择你要更新数据行，才能进行更新操作");

                }

            }

        }, '-', {

            text: '删除',

            iconCls: 'icon-remove',

            handler: function () {

                var row = $('#dg').datagrid("getSelections");//获取用户选择的数据行

                if (row && row.length > 0) {

                    if (row.length > 1) {

                        alert("当前一次只能删除一条记录");

                        return false;

                    } else {

                        $.messager.confirm('确认', '是否真的要删除所选择的数据行?',function(flag){
                            if(flag){
                                deletecourse(row[0].id);
                            }
                        })

                    }

                } else {

                    alert("请选择你要更新数据行，才能进行更新操作");

                }


            }

        }, '-', {

            text: '导入数据',

            iconCls: 'icon-help',

            handler: function () {

                alert('导入数据按钮')

            }

        }, '-', {

            text: '导出数据',

            iconCls: 'icon-help',

            handler: function () {

                alert("导出数据");

            }

        }, '-', {

            text: '搜索',

            iconCls: 'icon-search',

            handler: function () {

                alert("搜索数据");

            }

        }],

        columns: [[{

            field: 'id',

            title: '编号',

            width: 100,

            hidden: true

        }, {

            field: 'code',

            title: '课程代码',

            width: 100

        }, {

            field: 'name',

            title: '课程名称',

            width: 200

        }, {

            field: 'period',

            title: '课时',

            width: 200

        }, {

            field: 'nature',

            title: '课程类型',

            width: 200

        }]]

    });

}
