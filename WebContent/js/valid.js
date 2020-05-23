//SELECTING ALL TEXT ELEMENTS
var username = document.forms['formRegister']['username'];
var password = document.forms['formRegister']['password'];
var password_confirm = document.forms['formRegister']['pass_confirm'];
// SELECTING ALL ERROR DISPLAY ELEMENTS
var name_error = document.getElementById('username_err');
var password_error = document.getElementById('password_err');
var repassword_error = document.getElementById('repassword_err');
// SETTING ALL EVENT LISTENERS
username.addEventListener('blur', nameVerify, true);
password.addEventListener('blur', passwordVerify, true);
// validation function
function Validate() {
  // validate username
  if (username.value == "") {
    username.style.border = "1px solid red";
    document.getElementById('username').style.color = "red";
    //name_error.textContent = "Username is required";
    //username.focus();
    return false;
  }
  // validate username
  if (username.value.length < 3) {
    username.style.border = "1px solid red";
    document.getElementById('username').style.color = "red";
    //name_error.textContent = "Username must be at least 3 characters";
   // username.focus();
    return false;
  }
  // validate password
  if (password.value == "") {
    password.style.border = "1px solid red";
    document.getElementById('password').style.color = "red";
    password_confirm.style.border = "1px solid red";
    //password_error.textContent = "Password is required";
    //password.focus();
    return false;
  }
  // check if the two passwords match
  if (password.value != password_confirm.value) {
    password.style.border = "1px solid red";
    document.getElementById('pass_confirm').style.color = "red";
    //password_confirm.style.border = "1px solid red";
    //password_error.innerHTML = "The two passwords do not match";
    return false;
  }
}
// event handler functions
function nameVerify() {
  if (username.value != "") {
   username.style.border = "1px solid #5e6e66";
   document.getElementById('username').style.color = "#5e6e66";
  // name_error.innerHTML = "";
   return true;
  }
}
function passwordVerify() {
  if (password.value != "") {
  	password.style.border = "1px solid #5e6e66";
  	document.getElementById('pass_confirm').style.color = "#5e6e66";
  	document.getElementById('password').style.color = "#5e6e66";
  	//password_error.innerHTML = "";
  	return true;
  }
  if (password.value === password_confirm.value) {
  	password.style.border = "1px solid #5e6e66";
  	document.getElementById('pass_confirm').style.color = "#5e6e66";
  	//password_error.innerHTML = "";
  	return true;
  }
}