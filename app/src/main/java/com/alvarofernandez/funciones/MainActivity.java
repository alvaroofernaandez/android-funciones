package com.alvarofernandez.funciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int numero1;
    int numero2;
    CharSequence texto;
    int duracion = Toast.LENGTH_SHORT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero1 = 1;
        numero2 = 0;
        TextView myTextView1 = findViewById(R.id.txvNum1);
        TextView myTextView2 = findViewById(R.id.txvNum2);
        myTextView1.setText("Número 1: " + this.numero1);
        myTextView2.setText("Número 2: " + this.numero2);
    }

    public void funcionIncrementar(View view) {
        if (!diferenciaMaxima(this.numero1, this.numero2)) {
            numero1 = this.numero1 + 1;
            numero2 = this.numero2 + 4;

            TextView myTextView1 = findViewById(R.id.txvNum1);
            TextView myTextView2 = findViewById(R.id.txvNum2);
            myTextView1.setText("Número 1: " + numero1);
            myTextView2.setText("Número 2: " + numero2);

            texto = "Incrementado";
            Toast toast = Toast.makeText(this, texto, duracion);
            toast.show();
            Log.i("Funcion incrementar", "El valor actual del primer número es: "
                    + numero1 + " y el del numero 2 es: " + numero2);
        } else {
            texto = "No se ha podido incrementar debido a que la diferencia entre ambos números ya es superior a 50. ";
            Toast toast = Toast.makeText(this, texto, duracion);
            toast.show();
            Log.i("Funcion incrementar", "No se ha podido incrementar debido a que la diferencia entre ambos números ya es superior a 50.");
        }

    }

    public void funcionSumar(View view) {
        if (verificarPar(this.numero1, this.numero2) && !diferenciaMaxima(this.numero1, this.numero2)) {
            int resultadoSuma = this.numero1 + this.numero2;
            texto = "Resultado de la suma: " + resultadoSuma;
            Toast toast = Toast.makeText(this, texto, duracion);
            toast.show();
            Log.i("Funcion sumar", "El resultado de la suma es: " + resultadoSuma);
        } else if (diferenciaMaxima(this.numero1, this.numero2)) {
            Toast.makeText(this, "La suma no se realizara debido a que la diferencia entre ambos es superior a 50. ", Toast.LENGTH_SHORT).show();
            Log.i("Funcion sumar", "La suma no se ha realizado debido a que la diferencia entre ambos es superior a 50. ");
        } else {
            Toast.makeText(this, "La suma no se realizara debido a que los dos números no son pares. ", Toast.LENGTH_SHORT).show();
            Log.i("Funcion sumar", "La suma no se ha realizado debido a que los dos números no son pares. ");
        }
    }

    public void funcionRestar(View view) {
        if (verificarPar(this.numero1, this.numero2) && !diferenciaMaxima(this.numero1, this.numero2)) {
            int resultadoResta = this.numero1 - this.numero2;
            texto = "Resultado de la resta: " + resultadoResta;
            Toast toast = Toast.makeText(this, texto, duracion);
            toast.show();
            Log.i("Funcion restar", "El resultado de la resta es: " + resultadoResta);
        } else if (diferenciaMaxima(this.numero1, this.numero2)) {
            Toast.makeText(this, "La resta no se realizara debido a que la diferencia entre ambos es superior a 50. ", Toast.LENGTH_SHORT).show();
            Log.i("Funcion restar", "La resta no se ha realizado debido a que la diferencia entre ambos es superior a 50. ");
        } else {
            Toast.makeText(this, "La resta no se realizara debido a que los dos números no son pares. ", Toast.LENGTH_SHORT).show();
            Log.i("Funcion restar", "La resta no se ha realizado debido a que los dos números no son pares. ");
        }
    }

    public void funcionResetear(View view) {
        numero1 = this.numero1 = 1;
        numero2 = this.numero2 = 0;
        TextView myTextView1 = findViewById(R.id.txvNum1);
        TextView myTextView2 = findViewById(R.id.txvNum2);
        myTextView1.setText("Número 1: " + numero1);
        myTextView2.setText("Número 2: " + numero2);

        texto = "Números reseteados a su valor inicial.";
        Toast toast = Toast.makeText(this, texto, duracion);
        toast.show();

        Log.i("Funcion resetear", "Números reseteados a valor inicial, ahora el valor actual del primer número es: "
                + numero1 + " y el del numero 2 es: " + numero2);
    }

    public void funcionMediaAritmetica(View view) {

        int menor = Math.min(numero1, numero2);
        int mayor = Math.max(numero1, numero2);

        int mediaAritmetica = (menor + mayor) / 2;
        Log.i("Funcion media aritmética", "La media aritmética entre " + menor + " y " + mayor + " es: " + mediaAritmetica);

        Toast toastTopLeft = Toast.makeText(this, "Media: " + mediaAritmetica, Toast.LENGTH_SHORT);
        toastTopLeft.setGravity(android.view.Gravity.TOP | android.view.Gravity.START, 0, 0);
        toastTopLeft.show();

        Toast toastTopRight = Toast.makeText(this, "Media: " + mediaAritmetica, Toast.LENGTH_SHORT);
        toastTopRight.setGravity(android.view.Gravity.TOP | android.view.Gravity.END, 0, 0);
        toastTopRight.show();

        Toast toastBottomLeft = Toast.makeText(this, "Media: " + mediaAritmetica, Toast.LENGTH_LONG);
        toastBottomLeft.setGravity(android.view.Gravity.BOTTOM | android.view.Gravity.START, 0, 0);
        toastBottomLeft.show();

        Toast toastBottomRight = Toast.makeText(this, "Media: " + mediaAritmetica, Toast.LENGTH_LONG);
        toastBottomRight.setGravity(android.view.Gravity.BOTTOM | android.view.Gravity.END, 0, 0);
        toastBottomRight.show();
    }

    public static boolean verificarPar(int a, int b) {
        if (a % 2 == 0 && b % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean diferenciaMaxima(int i, int j) {
        int diferencia = i - j;
        if (Math.abs(diferencia) > 50 ) {
            return true;
        } else {
            return false;
        }
    }

    public void funcionFactorial(View view) {
        int factorialNum1 = factorial(numero1);
        int factorialNum2 = factorial(numero2);

        texto = "Factorial de " + numero1 + " es: " + factorialNum1 + "\n"
                + "Factorial de " + numero2 + " es: " + factorialNum2;
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }

    public int factorial(int numero) {
        if (numero == 0 || numero == 1) {
            return 1;
        }
        int resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }

        Log.i("Funcion factorial", "El factorial de " + numero + " es: " + resultado);

        return resultado;
    }
}