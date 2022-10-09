# Lexical Analysis

## Tests

Start script `check2.sh` using command `bash check.sh`\

* NOTE: you had to update classpath inside check2.sh to correspond to your *.class folder

## `Token Types:`
 * IDN, // identifikator
	
* BROJ, // konstante
	
* OP_PRIDRUZI, // =
	
* OP_PLUS, // +
	
* OP_MINUS, // -
	
* OP_PUTA, // *
	
* OP_DIJELI, // /
	
* L_ZAGRADA, // (
	
* D_ZAGRADA, // )
	
* KR_ZA, // start of while
	
* KR_OD, // of index
	
* KR_DO, // to index
	
* KR_AZ, // end of while
	
* COMMENT,
	
* EOF, //end of program, fila

## Example
Input:
```
// stavi sumu kubova prvih deset prirodnih brojeva u varijablu rez
n = 10 // varijable ne treba deklarirati prije inicijalizacije
rez = 0
za i od 1 do n
  rez = rez + i*i*i
az
```

Output:
```
IDN 2 n
OP_PRIDRUZI 2 =
BROJ 2 10
IDN 3 rez
OP_PRIDRUZI 3 =
BROJ 3 0
KR_ZA 4 za
IDN 4 i
KR_OD 4 od
BROJ 4 1
KR_DO 4 do
IDN 4 n
IDN 5 rez
OP_PRIDRUZI 5 =
IDN 5 rez
OP_PLUS 5 +
IDN 5 i
OP_PUTA 5 *
IDN 5 i
OP_PUTA 5 *
IDN 5 i
KR_AZ 6 az

```
