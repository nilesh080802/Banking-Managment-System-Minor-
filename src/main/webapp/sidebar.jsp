<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<aside class="left-sidebar" data-sidebarbg="skin5">
        <!-- Sidebar scroll-->
        <div class="scroll-sidebar">
          <!-- Sidebar navigation-->
          <nav class="sidebar-nav">
            <ul id="sidebarnav" class="pt-4">
              <li class="sidebar-item">
                <a
                  class="sidebar-link waves-effect waves-dark sidebar-link"
                  href="indexnew.jsp"	
                  aria-expanded="false"
                  ><i class="mdi mdi-view-dashboard"></i
                  ><span class="hide-menu">Dashboard</span></a
                >
              </li>
              <li class="sidebar-item">
                <a
                  class="sidebar-link waves-effect waves-dark sidebar-link"
                  href="Customers.jsp"
                  aria-expanded="false"
                  ><i class="fas fa-chart-bar"></i
                  ><span class="hide-menu">New Customers</span></a
                >
              </li>

              <li class="sidebar-item">
                <a
                  class="sidebar-link waves-effect waves-dark sidebar-link"
                  href="${pageContext.request.contextPath }/CustomersController?action=cust"
                  aria-expanded="false"
                  ><i class=" fas fa-street-view"></i
                  ><span class="hide-menu">Customers</span></a>
              </li>
             
             <li class="sidebar-item">
                <a
                  class="sidebar-link waves-effect waves-dark sidebar-link"
                  href="${pageContext.request.contextPath }/TransactionsController?action=transactions"
                  aria-expanded="false"
                  ><i class=" fas fa-street-view"></i
                  ><span class="hide-menu">Transactions</span></a
                >
              </li>
             
    
              <li class="sidebar-item p-3">
                
              </li>
            </ul>
          </nav>
          <!-- End Sidebar navigation -->
        </div>
        <!-- End Sidebar scroll-->
      </aside>

</body>
</html>