/**
* Projeto de Software II
* Professor André Felipe Bürger
* 
* Exemplo do padrão de projeto Composite
*
*/

import java.util.ArrayList;

interface Figura {
  void desenha();
  void mudaCorDeFundo(int cor);
 }

class Circulo implements Figura {
  public void desenha() {
    System.out.println("Desenhando círculo");
  }
  public void mudaCorDeFundo(int cor) {
    System.out.println("Mudando cor do círculo para " + cor);
  }
}

class Triangulo implements Figura {
  public void desenha() {
    System.out.println("Desenhando triângulo");
  }
  public void mudaCorDeFundo(int cor) {
    System.out.println("Mudando cor do triângulo para " + cor);
  }
}

class FiguraAgrupada implements Figura {

  private ArrayList<Figura> figuras = new ArrayList<Figura>();
  // lista que vai armazenar as figuras agrupadas
  
  public void adicionar (Figura fig) {
    figuras.add(fig);
  }

  public void remover (Figura fig) {
    figuras.remove(fig);
  }

  public void desenha() {
    for (Figura fig: figuras) {
      fig.desenha();   
    }
  }

  public void mudaCorDeFundo(int cor) {
    for (Figura fig: figuras) {
      fig.mudaCorDeFundo(cor);   
    }
  }
}

class Cliente {
  void foo(Figura fig) {
    fig.desenha(); // chama desenha de figura simples ou agrupada
  }	
}

public class Main {
  public static void main(String[] args) {
    Cliente cliente = new Cliente();

    Circulo c1 = new Circulo();
    cliente.foo(c1);  // chama foo com figura simples

    Triangulo t1 = new Triangulo();
    Triangulo t2 = new Triangulo();
    
    FiguraAgrupada grupo = new FiguraAgrupada();
    grupo.adicionar(c1);
    grupo.adicionar(t1);
    grupo.adicionar(t2);
    cliente.foo(grupo); // chama foo com figura agrupada
  }
}