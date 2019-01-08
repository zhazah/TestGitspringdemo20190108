<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试SpringBoot</title>
</head>
<script src="/test/js/jquery-1.8.3.min.js"></script>
<script>
    $(document).ready(function () {
        $("#createCheckCode").attr("src","code.html?time='"+encodeURI(new Date())+"'")
    });
    function myReload () {
        $("#createCheckCode").attr("src","code.html?time='"+encodeURI(new Date())+"'")
    }
    function getTheCheckBoxValue() {
        obj = $('input[name="uimg"]');
        check_val = [];
        obj.each(function(i){
            if($(this).is(":checked")){
                check_val.push($(this).val());
            }
        });
        isPillbox=check_val.toString();//已字符串形式获取
        console.log(isPillbox);
        $('#uimgs').val(isPillbox);
    }
    function sub() {
        getTheCheckBoxValue();
        $("#sub").submit();
    }
    $(document).ready(function () {
        var uimg =  "${(user.uimg)!}";
        if(uimg != null && uimg != ""){
        var checkBoxArray = uimg.split(",");
        for(var i=0;i<checkBoxArray.length;i++){
            $("input[name='uimg']").each(function(){
                if($(this).val()==checkBoxArray[i]){
                    $(this).attr("checked","checked");
                }
            })
        }
        }


        var unickname = "${(user.unickname)!}";
        if(unickname != null && unickname != ""){
            $("#unickname").find("option[value='"+unickname+"']").attr("selected",true);

        }
        var uname = "${(user.uname)!}";
        if(uname != null && uname != ""){}
        $("input:radio[value='"+uname+"']").attr('checked','true');
    })
</script>
<style>
    .table-c table{border-right:1px solid #F00;border-bottom:1px solid #F00}
    .table-c table td{border-left:1px solid #F00;border-top:1px solid #F00}
</style>
<body>
<center>
    <#if (user.uid)??>
    <h1>修改</h1>
    <#else>
    <h1>添加</h1>
    </#if>
    <div class="table-c">
    <#if (user.uid)??>
    <form action="/boot/test/updateUsers.html" id="sub" method="post">
    <#else>
    <form action="/boot/test/addUser.html" id="sub" method="post">
    </#if>
        <table cellpadding="0" cellspacing="0" border="0">
            <input type="hidden" name="uid" value="${(user.uid)!}">
            <tr>
                <td align="center">用户头像:</td>
                <td align="center">
                    <input type="checkbox" name="uimg" value="图片1">图片1
                    <input type="checkbox" name="uimg" value="图片2">图片2
                    <input type="checkbox" name="uimg" value="图片3">图片3
                    <input type="checkbox" name="uimg" value="图片4">图片4
                    <input type="hidden" name="uimgs" id="uimgs" value="${(user.uimg)!}">
                    <#--<input type="checkbox" name="uimg" value="${(user.uimg)!}">-->
                </td>
            </tr>
            <tr>
                <td align="center">用户姓名:</td>
                <td align="center">
                    <select name="unickname" id="unickname">
                        <option value="Tom">Tom</option>
                        <option value="小明">小明</option>
                        <option value="小红">小红</option>
                        <option value="Davi">Davi</option>
                    </select>
                    <#--<input type="text" name="unickname" value="${(user.unickname)!}">-->
                </td>
            </tr>
            <tr>
                <td align="center">用户账号:</td>
                <td align="center">
                    <input type="radio" name="uname" id="uname" value="20999" />20999
                    <input type="radio" name="uname" id="uname" value="40454" />40454
                    <#--<input type="text" name="uname" value="${(user.uname)!}">-->
                </td>
            </tr>
            <tr>
                <td align="center">用户密码:</td>
                <td align="center"><input type="text" name="upassword" value="${(user.upassword)!}"></td>
            </tr>
            <tr>
                <td align="center">验证码:</td>
                <td align="center">
                    <input type="text" id="verifyCode" name="code" title="验证码" required="true" datatitle="验证码" msg="验证码不正确">
                    <span>${error!}</span>
                    <a href="#" onclick="myReload()"><img id="createCheckCode" src=""></a>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <button onclick="sub()">提交</button>
                    <#--<input type="submit" value="提交">-->
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
    </div>
</center>
</body>
</html>

