class StaticVariables{
  static int var1=77;
  public static void main(String[] args){
    StaticVariables obj = new StaticVariables();
    StaticVariables obj2 = new StaticVariables();
    obj.var1=88;
    obj2.var1=99;
    System.out.Println("var1 : "+obj.var1);
  }
}

//Output:
//var1 : 99
