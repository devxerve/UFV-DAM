# Generador de Arrays - Números Pares e Impares  
**Práctica Java | Universidad Francisco de Vitoria**

## Descripción  
Genera dos arrays: **números impares** (rango aleatorio 5–50) y **números pares** (rango 5–50, con tamaño igual al valor mínimo del array impar).  
Muestra ambos arrays en formato indexado, los valores mínimo y máximo de cada uno, y el **MCD (máximo común divisor)** entre el mínimo y el máximo del array par usando el **algoritmo de Euclides**.

## Funcionamiento  
El usuario introduce el tamaño del array impar (>0) con gestión de errores.  

- Llena el array impar con números aleatorios impares (rango 5–50).  
- El tamaño del array par será igual al número más pequeño encontrado en el array impar.  
- Llena el array par con números aleatorios pares (rango 5–50).  
- Muestra ambos arrays, los valores mínimo y máximo de cada uno, y el MCD entre los valores del array par (mínimo y máximo).

## Estructura del Código  

**Main.java** (200 líneas, 9 métodos)  
├── readInt(Scanner) → Valida la entrada numérica, devuelve 0 en caso de error  
├── numGen(min, max) → Generador de enteros aleatorios (rango inclusivo)
├── checkEven(num) → Devuelve true si es par (num % 2 == 0)  
├── fillOdds(odds[]) → Rellena con números impares aleatorios (5–50) usando *do-while* 
├── fillEvens(evens[]) → Rellena con números pares aleatorios (5–50) usando *do-while*
├── showArray(array[]) → Imprime en formato "[índice]=valor | "  
├── smallerNumber(array[]) → Búsqueda lineal para el valor mínimo (O(n))  
├── greaterNumber(array[]) → Búsqueda lineal para el valor máximo (O(n))  
└── gcd(a, b) → Algoritmo de Euclides (while b != 0)

## Ejemplo de Salida  

Por favor, introduce el tamaño del array que deseas crear:  
5  

Array de números impares  
=17 | =23 | =41 | =7 | =35 |  

Array de números pares  
=12 | =28 | =6 | =44 | =18 |  

El número mayor del array impar es: 41  
El número menor del array impar es: 7  
El número mayor del array par es: 44  
El número menor del array par es: 6  

El máximo común divisor de 6 y 44 es: 2  

## Características Principales  
- **Validación de entrada** para prevenir datos no numéricos.  
- **Rangos coherentes** (5–50) para ambos arrays.  
- **Cálculos almacenados** con variables evensSmall y evensGreat.  

---

**Autor:** [Javier Cervera Rodríguez] | Estudiante DAM | UFV  
**Versión:** 3.0 | 20 de diciembre de 2025  
