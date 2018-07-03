function subList(){
    var flag = 0; errorArray = [];
    if($("#school").val()==''){
        $("#school").parent().css({"border":"1px solid red","border-radius":"5px"});
        errorArray.push('school');
        flag = 1;
    }
    if($("#classb").val()==''){
        $("#classb").parent().css({"border":"1px solid red","border-radius":"5px"});
        errorArray.push('classb');
        flag = 1;
    }
    if($("#name").val()==''){
        $("#name").parent().css({"border":"1px solid red","border-radius":"5px"});
        errorArray.push('name');
        flag = 1;
    }
    if($("#phone").val()==''){
        $("#phone").parent().css({"border":"1px solid red","border-radius":"5px"});
        errorArray.push('phone');
        flag = 1;
    }
    if($("#height").val()==''){
        $("#height").parent().css({"border":"1px solid red","border-radius":"5px"});
        errorArray.push('height');
        flag = 1;
    }
    if($("#weight").val()==''){
        $("#weight").parent().css({"border":"1px solid red","border-radius":"5px"});
        errorArray.push('weight');
        flag = 1;
    }
    if(flag == 1){
        $("#"+errorArray[0]).focus();
        return false;
    }
    return true;
}
function removeBorder(item) {
    if($("#"+item).val()!=''){
        $("#"+item).parent().css({"border":"none"});
    }
}
$("#c_form").ajaxForm(function(data){
    if(data=="fail"){
        alert("该学生已提交过报名，请勿重复提交！");
    }else {
        window.location.href = "/success";
    }
});

