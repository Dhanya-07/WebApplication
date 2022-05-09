<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
	<style>
		body
		{
			background-color: silver;
		}
		#regForm {
			background-color: white;
  
  border-style: solid;
  margin: 100px auto;
  font-family: Raleway;
  padding: 40px;
  width: 70%;
  min-width: 300px;
}
* {
  box-sizing: border-box;
}
		.tab {
  display: none;
}
.step {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: blue;
  border: none;  
  border-radius: 50%;
  display: inline-block;
  opacity: 0.5;
}
#prevBtn
{
	background-color: grey;

}
#nextBtn
{
	background-color: lightgreen;

}
input.invalid
{
  background-color: pink;
  
}		
	</style>
	
</head>
<body>

	<form id="regForm" action="Register" method="post">
	<div class="tab"><b>Name:</b>
    <p><input placeholder="Name" oninput="this.className = ''" name="name_p"></p>
  </div>
  <div class="tab"><b>Age:</b>
    <p><input placeholder="Age" pattern="[0-9]{3}" oninput="this.className = ''" name="age_p"></p>
    </div>
  <div class="tab"><b>Gender:</b>     
    <p><br><input  placeholder="Gender" type="radio" oninput="this.className = ''" name="gender_p" onclick="myFunction(this.value)"  value="Male">Male <br>	
	<input placeholder="Gender" type="radio" name="gender_p" onclick="myFunction(this.value)" oninput="this.className = ''" value="Female">Female <br>
	<input placeholder="Gender" type="radio" name="gender_p" onclick="myFunction(this.value)" value="Prefer not to mention">Prefer not to mention</p>
</div>
  
  <div class="tab"><b>Best Director:</b>
    <p><br><input placeholder="Director" type="radio" oninput="this.className = ''" name="fav_dir" onclick="myFunction(this.value)"  value="Sudha Kongara Prasad" >Sudha Kongara Prasad <br>

	<input placeholder="Director" type="radio" name="fav_dir" oninput="this.className = ''" onclick="myFunction(this.value)" value="Meghna Gulzar">Meghna Gulzar<br>

	<input placeholder="Director"  type="radio" name="fav_dir" oninput="this.className = ''" onclick="myFunction(this.value)" value="Prasanth Varma">Prasanth Varma<br>

	<input placeholder="Director" type="radio" name="fav_dir" oninput="this.className = ''" onclick="myFunction(this.value)" value="Raghu Samarth">Raghu Samarth<br>

	<input placeholder="Director" type="radio" name="fav_dir" oninput="this.className = ''" onclick="myFunction(this.value)" value="Manu Ashokan">Manu Ashokan<br>

	<input placeholder="Director" type="radio" name="fav_dir" oninput="this.className = ''" onclick="myFunction(this.value)" value="Mari Selvaraj">Mari Selvaraj<br></p>
	</div>
  
  <div class="tab"><b>Best Movie:</b>
   <p><br><input placeholder= "Movie" type="radio" name="fav_mov" oninput="this.className = ''" onclick="myFunction(this.value)" value="Soorarai Potru">Soorarai Potru<br>

	<input placeholder= "Movie" type="radio" name="fav_mov" oninput="this.className = ''" onclick="myFunction(this.value)" value="Uyare">Uyare<br>
	
	<input placeholder= "Movie" type="radio" name="fav_mov" oninput="this.className = ''" onclick="myFunction(this.value)" value="Law">Law<br>

	<input placeholder= "Movie" type="radio" name="fav_mov" oninput="this.className = ''" onclick="myFunction(this.value)" value="Awe">Awe<br>

	<input placeholder= "Movie" type="radio" name="fav_mov" oninput="this.className = ''" onclick="myFunction(this.value)" value="Pariyerum Perumal">Pariyerum Perumal<br>

	<input placeholder= "Movie" type="radio" name="fav_mov" oninput="this.className = ''" onclick="myFunction(this.value)" value="Raazi">Raazi<br></p>
    </div>
    
	<div style="overflow:auto;">
    <div style="float:right;">
      <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
      <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
    </div>
  </div>
  
      <div style="text-align:center;margin-top:40px;">
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
     <span class="step"></span>
      <span class="step"></span>

  </div>
</form>
  <script>
var currentTab = 0; 
showTab(currentTab); 

function showTab(n) {
  // This function will display the specified tab 
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  fixStepIndicator(n)
}

function nextPrev(n) {
  
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  showTab(currentTab);
}

function validateForm() {
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  for (i = 0; i < y.length; i++) {
    if (y[i].value == "") {
      y[i].className += " invalid";
      valid = false;
    }
  }
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(n) {
  
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  x[n].className += " active";
}
</script>
<script>
function myFunction(gender_p) {
  document.getElementById("result").value = gender_p;
  document.getElementById("result").value = fav_dir;
  document.getElementById("result").value = fav_mov;
}
</script>
</body>
