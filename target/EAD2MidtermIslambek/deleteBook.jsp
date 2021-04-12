<%@include file="header.jsp"%>
<div class="login-form">
    <div class="well">
        <h3>Delete a Book</h3>
        <form action="DeleteBookServlet" method="post" align="center">
            <input type="hidden" name="action" value="delete">
            <label for="bookId">Book ID</label>
            <input type="text" class="ggg" placeholder="Enter Book ID" name="bookId" id="bookId"><br>
            <button type="submit" name="action" value="delete">Delete</button>
            <p><c:out value="${message}"/></p>
        </form>
    </div>
</div>
</body>
</html>