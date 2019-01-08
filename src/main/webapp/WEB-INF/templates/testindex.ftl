<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试SpringBoot</title>
</head>
<script src="/test/js/jquery-1.8.3.min.js"></script>
<script src="/test/js/jquery.page.js"></script>
<script src="/test/js/common.valitor.js"></script>
<script src="/test/js/jquery.cookie.js"></script>
<script>
    $(document).ready(function () {
       var url="http://www.baicu.com";
       if(url.substring(0,5) == "http:"){
           var s = url.substring(7);
           alert("s="+s);
           var surl = "https://"+s;
           alert("surl="+surl);
       }
       alert(surl)
       /*var s = url.substring(5);
       alert(s);*/
    });
    $(document).ready(function () {
        $("#createCheckCode").attr("src","code.html?time='"+encodeURI(new Date())+"'")
    });
    function myReload () {
        $("#createCheckCode").attr("src","code.html?time='"+encodeURI(new Date())+"'")
    }

        function deleteUser(id) {
        var flag = confirm('您是否要删除该条数据？');
        if(flag == true){
            /*$.cookie('testid_'+id,id,{ expires: 365 });*/
            $.ajax({
                url:"/boot/test/delete.html?id="+id,
                dataType:"json",
                date:{"id":id},
                type:"POST",
                success:function (obj) {
                    if(obj.state == 'success'){
                        alert("删除成功！");
                       /* alert($.cookie("testid_"+id));*/

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

    $(document).ready(function(){
        $("#btn1").click(function(){
            $('#test').load('/boot/test/insertUser.html',function (responseTxt,statusTxt,xhr) {
                alert("responseTxt:"+responseTxt);
                alert("statusTxt:"+statusTxt);
                alert("xhr:"+xhr);
                if(statusTxt=="success")
                    alert("外部内容加载成功！");
                if(statusTxt=="error")
                    alert("Error: "+xhr.status+": "+xhr.statusText);

            });
        })
    })

    function showMask(){
        $("#mask").css("height",$(document).height());
        $("#mask").css("width",$(document).width());
        $("#mask").show();
    }
    //隐藏遮罩层
    function hideMask(){

        $("#mask").hide();
    }
</script>
<style>
    .table-c table{border-right:1px solid #F00;border-bottom:1px solid #F00}
    .table-c table td{border-left:1px solid #F00;border-top:1px solid #F00}
    .mask {
        position: absolute; top: 0px; filter: alpha(opacity=60); background-color: #777;
        z-index: 1002; left: 0px;
        opacity:0.5; -moz-opacity:0.5;
    }
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
        <h2 id="test">测试修改文本内容</h2>
        <button id="btn1">点击修改</button>
        <div id="mask" class="mask">
            <center>
                <div style="background-color: white;width: 200px;height: 200px;">
                    <a href="javascript:;" onclick="hideMask()" >点我隐藏遮罩层</a><br />
                </div>
            </center>
        </div>
        <a href="javascript:;" onclick="showMask()" >点我显示遮罩层</a><br />
    <#--<a href="#" onclick="myReload()"><img id="createCheckCode" src=""></a>-->
        <#--<img src="https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=d50d97645a0fd9f9a017526f1d16b317/d31b0ef41bd5ad6ee331dcf28acb39dbb7fd3cd9.jpg">-->
        <#--${PageHtml}-->
    </div>
</center>
</body>
</html>