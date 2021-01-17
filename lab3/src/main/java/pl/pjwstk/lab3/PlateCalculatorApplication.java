package pl.pjwstk.lab3;

public class PlateCalculatorApplication {
    private PlateCalculator plateService;

    public void setPlateService(PlateCalculator plateService){
        this.plateService = plateService;
    }

    public int platecalculator(int input1){
        return plateService.calculate(input1);
    }

    public int availabeheavy(int input1, int input2){
        return plateService.availableHeavy(input1, input2);
    }
}
