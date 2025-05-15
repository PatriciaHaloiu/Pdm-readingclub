# Reading Club - Aplicație Android

Această aplicație Android este o extensie a platformei Reading Club, oferind utilizatorilor posibilitatea de a:

- Calcula timpul de lectură estimat
- Împrumuta și returna cărți
- Participa la quiz-uri despre literatură
- Accesa interfața Home cu navigare între module
- Se autentifica și înregistra în aplicație

## Funcționalități

- **Autentificare și Înregistrare**
  - `Login.java`, `SingUp.java`
  - Folosește `DBHelper.java` cu SQLite pentru stocarea locală a utilizatorilor

- **Navigare principală**
  - `MainActivity.java`: splash screen cu animație
  - `Home.java`: meniu principal cu butoane pentru fiecare funcționalitate

- **Module**
  - `Calculeaza.java`: calculează timpul necesar pentru a citi o carte
  - `Issue.java`: înregistrează un împrumut (simulat)
  - `Return.java`: procesează o returnare (simulată)
  - `Quiz.java`: quiz literar cu cronometru și întrebări multiple
  - `QuestionModel.java`: modelul de întrebare folosit în quiz

## Baza de date

- **Tip**: SQLite
- **Tabel**: `users`
  - `username` (TEXT, PK)
  - `password` (TEXT)

## Structura fișierelor

| Fișier Java        | Funcționalitate                                       |
|--------------------|--------------------------------------------------------|
| `MainActivity.java`| Splash screen cu animații                             |
| `Login.java`       | Autentificare utilizator                              |
| `SingUp.java`      | Înregistrare cont nou                                 |
| `Home.java`        | Meniu principal                                       |
| `Calculeaza.java`  | Calculator timp de lectură                            |
| `Issue.java`       | Înregistrare împrumut                                 |
| `Return.java`      | Înregistrare returnare                                |
| `Quiz.java`        | Test grilă despre literatură                          |
| `QuestionModel.java` | Model întrebare quiz                               |
| `DBHelper.java`    | Gestionare SQLite                                     |

## Cerințe

- Android Studio
- SDK min. 21+
- Gradle + support libraries

## Autor

Proiect realizat ca extensie Android a aplicației Reading Club.
