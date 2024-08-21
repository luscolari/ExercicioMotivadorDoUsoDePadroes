public class Carro {

    private String modelo;
    private Motor motor;
    private TanqueCombustivel tanque;

    //Construtor modificado para poder aceitar Carros Econos e não precisar criar um novo contrutor.
    public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumoMotor, int capacidadeTanque) {
        this.modelo = modelo;
        if(modelo.equals("Econo")){
            motor = new Motor (tipoCombustivel, consumoMotor, 0);
        } else {
            motor = new Motor(tipoCombustivel, consumoMotor);
        }
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }

    // Construtor para carro com Motor FLEX, aqui foi necessário adiconar um boolean, pois se não teria
    // as mesmas coisas nos parâmetros.
    public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumoMotor, int capacidadeTanque, boolean Motorflex) {
        this.modelo = modelo;
        this.motor = new Motor(tipoCombustivel, consumoMotor, Motorflex);
        this.tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }

    // Construtor para motores FLEX com consumo específico para gasolina e álcool.
    //Aqui é necessári o IF para descobrir qual foi o tipo de combustível usado pelo carro para
    // setar seu consumo.
    public Carro(String modelo, TipoCombustivel tipoCombustivel, int capacidadeTanque, boolean Motorflex) {
        this.modelo = modelo;
        if(tipoCombustivel.equals(tipoCombustivel.GASOLINA)){
            motor.setConsumo(8);
        } else if (tipoCombustivel.equals(tipoCombustivel.ALCOOL)){
            motor.setConsumo(6);
        }
        this.motor = new Motor(tipoCombustivel,motor.getConsumo());
        this.tanque = new TanqueCombustivel(TipoCombustivel.FLEX, capacidadeTanque); // Assumindo tanque FLEX
    }


    public String getModelo() {
        return modelo;
    }

    public int getCombustivelDisponivel() {
        return tanque.getCombustivelDisponivel();
    }

    // Retorna a quantidade efetivamente abastecida
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel();
        if (capacidadeLivre < quantidade) {
            tanque.abastece(tipoCombustivel, capacidadeLivre);
            return capacidadeLivre;
        } else {
            tanque.abastece(tipoCombustivel, quantidade);
            return quantidade;
        }
    }

    // Retorna a distancia que consegue viajar com o combustivel remanescente
    public int verificaSePodeViajar(int distancia) {
        int combustivelNecessario = motor.combustivelNecessario(distancia);
        if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
            return distancia;
        } else {
            return tanque.getCombustivelDisponivel() * motor.getConsumo();
        }
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);
            tanque.gasta(motor.combustivelNecessario(distancia));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
