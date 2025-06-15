Thêm mssql-jdbc-12.10.0.jre11 vào java build path, thêm cả vào lib của tomcat
sử dụng tomcat 9
bật tcp và sql server brower lên nếu chưa bật
+cấu trúc thư mục
BT/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── BTL/
│       │       ├── controllers/
│       │       │   ├── AuthServlet.java
│       │       │   └── BinhLuanServlet.java
│       │       │
│       │       ├── daos/
│       │       │   ├── BinhLuanDAO.java
│       │       │   └── NguoiDungDAO.java
│       │       │
│       │       ├── models/
│       │       │   ├── BinhLuan.java
│       │       │   └── NguoiDung.java
│       │       │
│       │       ├── patterns/
│       │       │   ├── BinhLuanMemento.java
│       │       │   ├── BinhLuanOriginator.java
│       │       │   ├── QuanLyBinhLuanFacade.java
│       │       │   └── QuanLyNguoiDungFacade.java
│       │       │
│       │       └── utils/
│       │           └── DBConnection.java
│       │
│       └── webapp/
│           ├── auth/
│           │   ├── dangKy.jsp
│           │   ├── dangNhap.jsp
│           │   └── thongTinCaNhan.jsp
│           │
│           ├── binhluan/
│           │   ├── themBinhLuan.jsp
│           │   └── xemBinhLuan.jsp
│           │
│           ├── layouts/
│           │   └── header.jsp
│           │
│           ├── META-INF/
│           └── WEB-INF/
│               ├── lib/
│               │   ├── servlet-api.jar
│               │   ├── mssql-jdbc-12.10.0.jre11.jar
│               │   ├── jstl-1.2.jar
│               │   └── standard-1.1.2.jar
│               │
│               └── web.xml
│
├── build/               (nếu không dùng Maven)
│
└── pom.xml              (nếu dùng Maven)

