class staticExample{
  static int num;
  static string mystr;
  static{
    System.out.Println("Block1");
    num = 68;
    mystr = "Block 1";
  }
  static{
    System.out.Println("Block2");
    num = 98;
    mystr = "Block 2";
  }
  public static void main(String[] args){
        System.out.Println("num : "+num);
        System.out.Println("mystr : "+mystr);
  }
}

//Output:
//Block1
//Block2
//num : 98
//mystr : Block 2
