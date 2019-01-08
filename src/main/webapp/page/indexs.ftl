<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>template测试SpringBoot</title>
</head>
<script src="/test/js/jquery-1.8.3.min.js"></script>
<script>
    function deleteUser(id) {
        var flag = confirm('您是否要删除该条数据？');
        if(flag == true){
            $.ajax({
                url:"/boot/test/delete.html?id="+id,
                dataType:"json",
                date:{"id":id},
                type:"POST",
                success:function (obj) {
                    if(obj.state == 'success'){
                        alert("删除成功！");
                        window.location.reload();
                    }else{
                        alert("删除失败！")
                    }
                },
            })
        }else{
            console.log("删除失败！")
        }
    }
</script>
<style>
    .table-c table{border-right:1px solid #F00;border-bottom:1px solid #F00}
    .table-c table td{border-left:1px solid #F00;border-top:1px solid #F00}
</style>
<body>
<center>
    <h1>Hello,SpringBoot.</h1>
    <a href="/boot/test/insertUser.html" target="_top" style="margin-left: 300px">添加</a>
    <div class="table-c">
    <table cellpadding="0" cellspacing="0" border="0">
        <tr>
            <td align="center">用户id</td>
            <td align="center">昵称</td>
            <td align="center">账号</td>
            <td align="center">密码</td>
            <td align="center">头像</td>
            <td align="center" width="50">功能</td>
            <td align="center" width="50">功能</td>
        </tr>
        <#if userList??>
            <#list userList as user>
                <tr>
                    <td align="center">${(user_index+1)!}</td>
                    <td align="center">${user.unickname!}</td>
                    <td align="center">${user.uname!}</td>
                    <td align="center">${user.upassword!}</td>
                    <td align="center">${user.uimg!}</td>
                    <td align="center" width="50"><a href="#" onclick="deleteUser('${user.uid}')">删除</a></td>
                    <td align="center" width="50"><a href="/boot/test/updateUser.html?uid=${user.uid}">修改</a></td>
                </tr>
            </#list>
        </#if>
    </table>
    </div>
</center>
</body>
</html>