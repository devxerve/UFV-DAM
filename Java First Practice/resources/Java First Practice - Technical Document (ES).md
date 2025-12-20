# Generador de Arrays - Números Pares e Impares  
**Práctica Java | Universidad Francisco de Vitoria**

## Descripción  
Genera dos arrays: **números impares** (rango aleatorio 5–50) y **números pares** (rango 1-tamaño, con tamaño igual al valor mínimo del array impar).  
Muestra ambos arrays en formato indexado, los valores mínimo y máximo de cada uno, y el **MCD (máximo común divisor)** entre el mínimo y el máximo del array par usando el **algoritmo de Euclides**.

## Funcionamiento  
El usuario introduce el tamaño del array impar (>0) con gestión de errores.  

- Llena el array impar con números aleatorios impares (rango 5–50).  
- El tamaño del array par será igual al número más pequeño encontrado en el array impar.  
- Llena el array par con números aleatorios pares (rango 1–tamaño).  
- Muestra ambos arrays, los valores mínimo y máximo de cada uno, y el MCD entre los valores del array par (mínimo y máximo).

## Estructura del Código  

**Main.java** (200 líneas, 9 métodos)  
├── readInt(Scanner) → Valida la entrada numérica, devuelve 0 en caso de error 


├── numGen(min, max) → Generador de enteros aleatorios (rango inclusivo)

├── checkEven(num) → Devuelve true si es par (num % 2 == 0)  

├── fillOdds(odds[]) → Rellena con números impares aleatorios (5–50) usando *do-while* 

├── fillEvens(evens[]) → Rellena con números pares aleatorios (1-evens.lenght) usando *do-while*

├── showArray(array[]) → Imprime en formato "[índice]=valor | "  

├── smallerNumber(array[]) → Búsqueda lineal para el valor mínimo (O(n))  

├── greaterNumber(array[]) → Búsqueda lineal para el valor máximo (O(n))  

└── gcd(a, b) → Algoritmo de Euclides (while b != 0)

## Ejemplo de Salida  

Por favor, introduce el tamaño del array que deseas crear:  
5  


Array de numeros Impares

[0] =17 |[1] =23 | [2] =41 | [3] =7 | [4] =35 |

Array de numeros pares

[0] =2 | [1] =2 | [2] =6 | [3] =4 | [4] =2 | [5] = 6 | [6] = 2

El numero mayor del Array que contiene Impares es :  41

El numero menor del Array que contiene Impares es : 7

El numero mayor del Array que contiene Pares es : 6

El numero menor del Array que contiene Pares es :2

El máximo común divisor de 6 y 4 es: 2   

## Características Principales  
- **Validación de entrada** para prevenir datos no numéricos.  
- **Rangos coherentes** 5-50 para el Array de impares, 1-tamaño para el array de numeros pares  
- **Cálculos almacenados** con variables evensSmall y evensGreat.  

---

**Autor:** [Javier Cervera Rodríguez] | Estudiante DAM | UFV  
**Versión:** 4.0 | 20 de diciembre de 2025  
