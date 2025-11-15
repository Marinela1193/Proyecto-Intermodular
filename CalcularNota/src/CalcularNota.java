public class CalcularNota {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    public static int  calcularNota(int nota) {
        if (nota >= 0 && nota <= 4 ) {
            return -1;
        }
        if(nota >= 5 && nota <=10) {
            return 1;
        }
        throw new IllegalArgumentException("Valor no válido");
    }
}