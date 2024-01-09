Pengerjaan Tugas PR-18 modul-20 API Automation. 

Framework : JUnit

Kerangka Otomasi API : POM

Testcases : Gherkin, dengan skenario:

            1. Get data user
            
            2. Create new user (positive case)
            
            3. Create New User - without name (negative case)
            
            4. Update (Patch) user Name (Positive)
            
            5. Update (Patch) edge test -"Status edge : active / inactive, filled by NA"  (Negative Edge Test)
            
            6. Test Delete User

Kerangka POM dengan struktur package sebagai berikut:

features : tempat file.feature yang berisi test skenario dalam bentuk gherkin format
StepDef : merupakan tempat step definition. Step definition menghubungkan gherkin (file.feature) dengan logic pemrograman yang ada di pages. 
pages : berisikan logic pemrograman
Utility : berisikan utility dari test api automation dan File Json Schema
Helper : berisikan file java yang digunakan oleh class yang berada pada ‘pages.
runner : digunakan untuk melakukan run dan generate report.
