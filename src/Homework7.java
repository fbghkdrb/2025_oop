abstract class Printer {
    protected String model;
    protected int printedCount;
    protected int availableCount;

    public Printer(String model, int availableCount) {
        this.model = model;
        this.printedCount = 0;
        this.availableCount = availableCount;
    }

    public abstract boolean print();
}

class InkjetPrinter extends Printer {
    public InkjetPrinter(String model, int availableCount) {
        super(model, availableCount);
    }

    @Override
    public boolean print() {
        if (availableCount > 0) {
            printedCount++;
            availableCount--;
            return true;
        } else {
            int failureCount = printedCount + 1;
            System.out.println(model + ": " + failureCount + "매째 인쇄 실패 - 잉크 부족.");
            return false;
        }
    }
}

class LaserPrinter extends Printer {
    public LaserPrinter(String model, int availableCount) {
        super(model, availableCount);
    }

    @Override
    public boolean print() {
        if (availableCount > 0) {
            printedCount++;
            availableCount--;
            return true;
        } else {
            int failureCount = printedCount + 1;
            System.out.println(model + ": " + failureCount + "매째 인쇄 실패 - 토너 부족.");
            return false;
        }
    }
}

public class Homework7 {
    public static void main(String[] args) {
        InkjetPrinter inkjet = new InkjetPrinter("Brother DCP-T730DW", 7500);
        LaserPrinter laser = new LaserPrinter("Canon MFC643Cdw", 1500);
        while (inkjet.print());
        while (laser.print());
    }
}