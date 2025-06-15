-Thêm mssql-jdbc-12.10.0.jre11 trong file sqljdbc vào java build path, thêm cả vào lib của tomcat
-sử dụng tomcat 9
-cài tất cả các file trong mục tải, xong chọn file-> new ->dynamic web project( chưa hiện dynamic thì bật lên)
-chỉnh dynamic trong project facets: chuột phải properties file dynamic -> project facets -> dynamic web module thành 3.1( không chỉnh lỗi jsp)
-bật tcp và sql server brower lên nếu chưa bật
-kiểm tra kĩ file DBConnection khi chạy, hay bị lỗi nếu url không đúng
tomcat chạy file trong webapp/
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

