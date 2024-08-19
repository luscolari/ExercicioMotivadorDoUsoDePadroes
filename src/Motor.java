public class Motor {

    private TipoCombustivel tipoMotor;
    private int consumo; // em quilometros por unidade. Ex: Km/Lt
    private int quilometragem;
    private boolean Econo; // criado para marcar se um carro é Econo.
    private int consumoMinimo; // criado para dizer qual o consumo minimo do carro Econo.
    private int consumoGasolina; // criado para especificar em Flex o consumo de gasolina.
    private int consumoAlcool; // criado para especificar em Flex o consumo de álcool.
    private boolean flex; // criado para dizer que o motor é FLEX.

    public Motor(TipoCombustivel tipoMotor, int consumo) {
        this.tipoMotor = tipoMotor;
        this.consumo = consumo;
    }

    public Motor(TipoCombustivel tipoMotor, int consumo, boolean flex) {
        this.tipoMotor = tipoMotor;
        this.consumo = consumo;
    }

    //Construtor para Carro FLEX com consumo específico para gasolina e álcool
   public Motor(int consumoGasolina, int consumoAlcool) {
        this.tipoMotor = TipoCombustivel.FLEX;
        this.consumoGasolina = consumoGasolina;
        this.consumoAlcool = consumoAlcool;
   }

    //Construtor para o Motor do Econo que o consumo reduz ao longo que o carro ande.
    public Motor(TipoCombustivel tipoMotor, int consumo, int consumoMinimo) {
        this.tipoMotor = tipoMotor;
        this.consumo = consumo;
        this.consumoMinimo = consumoMinimo;
        quilometragem = 0;
        Econo = true;
    }

    //Aqui para saber se é Econo, faça a lógica de diminuição do consumo. 
    //Se não, só retorne o consumo.
    public int getConsumo() {
        if(Econo == true){
        if(consumo != consumoMinimo){
            consumo = consumo - (quilometragem / 5000);
        }
    }
        return this.consumo;
    }

    public TipoCombustivel getTipoMotor(){
        return this.tipoMotor;
    }

    public int getQuilometragem(){
        return this.quilometragem;
    }

    public int combustivelNecessario(int distancia) {
        return distancia / consumo;
    }

    public void percorre(int distancia) {
        quilometragem += distancia;
    }

    @Override
    public String toString() {
        return "Motor [consumo=" + consumo + ", quilometragem=" + quilometragem + ", tipoMotor=" + tipoMotor + "]";
    }
}