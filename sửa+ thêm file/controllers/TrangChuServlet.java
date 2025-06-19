// Source code is decompiled from a .class file using FernFlower decompiler.
package BTL.controllers;

import BTL.daos.LoaiSanPhamDAO;
import BTL.daos.SanPhamDAO;
import BTL.models.LoaiSanPham;
import BTL.models.SanPham;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/trang-chu"})
public class TrangChuServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public TrangChuServlet() {
   }

   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String idLoaiStr = req.getParameter("idLoai");
      int idLoai = 0;

      try {
         idLoai = Integer.parseInt(idLoaiStr);
      } catch (Exception var9) {
      }

      SanPhamDAO spDAO = new SanPhamDAO();
      LoaiSanPhamDAO loaiDAO = new LoaiSanPhamDAO();
      List<SanPham> dsSanPham = idLoai > 0 ? spDAO.layTheoLoai(idLoai) : spDAO.layTatCa();
      List<LoaiSanPham> dsLoai = loaiDAO.layTatCa();
      req.setAttribute("danhSachSanPham", dsSanPham);
      req.setAttribute("danhSachLoai", dsLoai);
      req.setAttribute("content", "/views/trangChu.jsp");
      req.getRequestDispatcher("/layouts/index.jsp").forward(req, resp);
   }
}
