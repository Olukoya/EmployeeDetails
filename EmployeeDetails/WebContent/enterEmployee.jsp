<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Enter Employee Details</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Enter Employee Details Here:</h2>
  <form action="Form" method="POST">
    <div class="form-group">
      <label for="eNumber">Employee Number:</label>
      <input type="text" class="form-control" id="eNumber" placeholder="Enter employee number">
    </div>
    <div class="form-group">
      <label for="fName">First Name:</label>
      <input type="text" class="form-control" id="fName" placeholder="Enter first name">
    </div>
        <div class="form-group">
      <label for="lName">Last Name:</label>
      <input type="text" class="form-control" id="lName" placeholder="Enter last name">
    </div>
        <div class="form-group">
      <label for="dept">Department:</label>
      <input type="text" class="form-control" id="dept" placeholder="Enter department">
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</body>
</html>