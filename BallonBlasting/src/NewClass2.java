public class NewClass2 {
    
   
   public static void main(String[]args){
        Box box=new Box();
        
   }
}
 class Box  implements  Pet{

    public Box() {
        this(0, 0, 0);
    }

    public Box(int length, int height, int width) {
        this.length = length;
        this.height = height;
        this.width = width;
    }
    
    
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
   public int length;
   public int height;
  public  int width;

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void setName(String name) {
       
    }
}

 interface Pet{
     String getName();
   public   void setName(String name);
    
}


