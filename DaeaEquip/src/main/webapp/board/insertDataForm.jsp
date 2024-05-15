<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Data</title>
    <style>
       
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Insert Data</h2>
        <form action="insertData.board" method="post">
            <label>
                <span>ID:</span>
                <input type="text" name="id" required>
            </label>
            
            <label>
                <span>Model:</span>
                <input type="text" name="model" required>
            </label>
            
            <label>
                <span>Manufacturer:</span>
                <input type="text" name="manufacturer" required>
            </label>
            
            <label>
                <span>Operator:</span>
                <input type="text" name="operator" required>
            </label>
            
            <label>
                <span>Department:</span>
                <input type="text" name="department" required>
            </label>
            
            <label>
                <span>IP:</span>
                <input type="text" name="ip" required>
            </label>
            
            <label>
                <span>Acquisition Date:</span>
                <input type="date" name="acqdate" required>
            </label>
            
            <button type="submit">Save</button>
        </form>
    </div>
</body>
</html>
