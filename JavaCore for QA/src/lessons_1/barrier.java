package lessons_1;

public class barrier {
    private BarrierType type;
    private int value;

    public enum BarrierType {JumpUP, JumpLen,  Weight}

    public barrier(BarrierType type, int value){
        this.type = type;
        this.value = value;
    }

    public BarrierType GetType(){
      return type;
    }

    public int  GetValue(){
        return  value;
    }
}

