package lessons_3;

public class ChangeArr<N> extends Fruit {

    private Double num;
    private Integer num2;

    ChangeArr(Double num, Integer num2){
        this.num = num;
        this.num2 = num2;
    }

    public Double getNum() {
        return num;
    }

    public Integer getNum2() {
        return num2;
    }
}
