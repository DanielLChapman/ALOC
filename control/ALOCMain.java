/*    */ package control;
/*    */ 
/*    */ import view.MainFrame;
/*    */ 
/*    */ public class ALOCMain
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 19 */     EDS eds = new EDS();
/* 20 */     MainFrame frame = new MainFrame(eds);
/* 21 */     frame.setVisible(true);
/*    */   }
/*    */ }
