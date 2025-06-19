// Source code is decompiled from a .class file using FernFlower decompiler.
package BTL.patterns;

import BTL.daos.SanPhamDAO;

public class DAOFactory {
   public DAOFactory() {
   }

   public static SanPhamDAO createSanPhamDAO() {
      return new SanPhamDAO();
   }
}
