<%@include file="header.jsp"%>
<div class="login-form">
    <div class="well">
        <h3>Update a Book</h3>
        <form action="UpdateBookServlet" method="post" align="center">
            <input type="hidden" name="action" value="update">
            <label for= "bookId">Book ID</label>
            <input type="text" class="ggg" placeholder="Enter Book ID" name="bookId" id="bookId"><br>
            <label for="title">Book Title</label>
            <input type="text" class="ggg" placeholder="Enter the title of the book" name="title" id="title"><br>
            <label for="author">Author(s)</label>
            <input type="text" class="ggg" placeholder="Enter the name of the author" name="author" id="author"><br>
            <button type="submit" name="action" value="update">Update</button><br>
            <p><c:out value="${message}"/></p>
        </form>
    </div>
</div>
</body>
</html>