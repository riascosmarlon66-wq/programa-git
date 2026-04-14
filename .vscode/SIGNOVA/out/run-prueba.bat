@echo off
echo Compilando...

javac -cp ".;lib/mysql-connector-j-9.6.0.jar" -d . com\signova\*.java dao\*.java

if %errorlevel% neq 0 (
    echo ERROR al compilar
    pause
    exit /b
)

echo Ejecutando...

java -cp ".;lib/mysql-connector-j-9.6.0.jar" com.signova.PruebaConexion

pause