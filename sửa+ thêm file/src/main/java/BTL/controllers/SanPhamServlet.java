// Source code is decompiled from a .class file using FernFlower decompiler.
package BTL.controllers;

import BTL.daos.BinhLuanDAO;
import BTL.daos.LoaiSanPhamDAO;
import BTL.models.LoaiSanPham;
import BTL.models.SanPham;
import BTL.services.QuanLySanPhamService;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/san-pham/*"})
public class SanPhamServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private QuanLySanPhamService sanPhamService = new QuanLySanPhamService();

   public SanPhamServlet() {
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action = request.getPathInfo();
      if (action != null && !action.equals("/quan-ly")) {
         if (action.equals("/them")) {
            request.setAttribute("sp", new SanPham());
            List<LoaiSanPham> danhSachLoai = (new LoaiSanPhamDAO()).layTatCa();
            request.setAttribute("danhSachLoai", danhSachLoai);
            request.getRequestDispatcher("/views/sanpham/themHoacSuaSanPham.jsp").forward(request, response);
         } else {
            SanPham sp;
            List danhSachBinhLuan;
            int id;
            if (action.equals("/sua")) {
               id = Integer.parseInt(request.getParameter("id"));
               sp = this.sanPhamService.timTheoId(id);
               request.setAttribute("sp", sp);
               danhSachBinhLuan = (new LoaiSanPhamDAO()).layTatCa();
               request.setAttribute("danhSachLoai", danhSachBinhLuan);
               request.getRequestDispatcher("/views/sanpham/themHoacSuaSanPham.jsp").forward(request, response);
            } else if (action.equals("/xoa")) {
               id = Integer.parseInt(request.getParameter("id"));
               this.sanPhamService.xoaSanPham(id);
               response.sendRedirect(request.getContextPath() + "/san-pham/quan-ly");
            } else if (action.equals("/chi-tiet")) {
               id = Integer.parseInt(request.getParameter("id"));
               sp = this.sanPhamService.timTheoId(id);
               if (sp == null) {
                  response.sendError(404);
                  return;
               }

               danhSachBinhLuan = (new BinhLuanDAO()).layTheoSanPham(id);
               request.setAttribute("danhSachBinhLuan", danhSachBinhLuan);
               request.setAttribute("sp", sp);
               request.getRequestDispatcher("/views/sanpham/chiTietSanPham.jsp").forward(request, response);
            } else {
               response.sendError(404);
            }
         }
      } else {
         this.hienThiDanhSachSanPham(request, response);
      }

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      int id = Integer.parseInt(request.getParameter("id"));
      String ten = request.getParameter("tenSanPham");
      String moTa = request.getParameter("moTa");
      double gia = Double.parseDouble(request.getParameter("gia"));
      int soLuong = Integer.parseInt(request.getParameter("soLuong"));
      String anhUrl = request.getParameter("anhUrl");
      int idLoai = Integer.parseInt(request.getParameter("idLoai"));
      SanPham sp = new SanPham();
      sp.setId(id);
      sp.setTenSanPham(ten);
      sp.setMoTa(moTa);
      sp.setGia(gia);
      sp.setSoLuong(soLuong);
      sp.setAnhUrl(anhUrl);
      sp.setIdLoai(idLoai);
      sp.setNgayCapNhat(new Timestamp(System.currentTimeMillis()));
      if (id == 0) {
         sp.setNgayTao(sp.getNgayCapNhat());
      } else {
         sp.setNgayTao(this.sanPhamService.timTheoId(id).getNgayTao());
      }

      this.sanPhamService.luuSanPham(sp);
      response.sendRedirect(request.getContextPath() + "/san-pham/quan-ly");
   }

   private void hienThiDanhSachSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      List<SanPham> danhSachSanPham = this.sanPhamService.layTatCaSanPham();
      request.setAttribute("danhSachSanPham", danhSachSanPham);
      request.getRequestDispatcher("/views/sanpham/quanLySanPham.jsp").forward(request, response);
   }
}
