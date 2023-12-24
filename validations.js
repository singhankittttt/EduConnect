function validation() {
    var usn = document.getElementById('usn').value;
    var user = document.getElementById('user').value;
    var dept = document.getElementById('dept').value;
    var sem = document.getElementById('sem').value;
    var email = document.getElementById('email').value;
    var monum = document.getElementById('monum').value;
    var pwd = document.getElementById('pass').value;
    var cpwd = document.getElementById('cpass').value;
   
    

    if (usn == "") {
        document.getElementById('usnumber').innerHTML = "**Enter usn here";
        return false;
    }

    if (user == "") {
        document.getElementById('username').innerHTML = "**Enter username here";
        return false;
    }
    if ((user.length <= 3) || (user.lentgh >= 15)) {
        document.getElementById('username').innerHTML = "**Username Should between 4 and 15";
        return false;
    }
    if (!isNaN(user)) {
        document.getElementById('username').innerHTML = "**Username Should Characters only";
        return false;
    }

    if (dept == "") {
        document.getElementById('department').innerHTML = "**Enter department here";
        return false;
    }

    if (sem == "") {
        document.getElementById('semester').innerHTML = "**Enter semester here";
        return false;
    }

    if (email == "") {
        document.getElementById('eid').innerHTML = "**Enter E-Mail id here";
        return false;
    }
    if(email.indexOf('@')<=0){
        document.getElementById('eid').innerHTML = "**Enter valid E-Mail id";
        return false;
    }

    if (monum == "") {
        document.getElementById('mono').innerHTML = "**Enter Mobile Number here";
        return false;
    }
    if (isNaN(monum)) {
        document.getElementById('mono').innerHTML = "**Mobile Number Should be Digits only";
        return false;
    }
    if (monum.length != 10) {
        document.getElementById('mono').innerHTML = "**Enter 10 Digits Mobile number only";
        return false;
    }
   

    if (pwd == "") {
        document.getElementById('pasd').innerHTML = "**Enter Password here";
        return false;
    }
    if ((pwd.length <= 5) || (user.lentgh >= 15)) {
        document.getElementById('pasd').innerHTML = "**Password Should more than 5 Characters";
        return false;
    }
        if (cpwd == "") {
            document.getElementById('cpasd').innerHTML = "**Enter Confirm Password here";
            return false;
        }
        if (pwd!=cpwd) {
            document.getElementById('cpasd').innerHTML = "**Password and Confirm Password is not matching ";
            return false;
        }
       
   
    

    }