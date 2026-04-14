@echo off
cd /d "%~dp0"

echo ========================================
echo Compilando proyecto SIGNOVA...
echo ========================================

set SRC_DIR=%CD%\src
set CLASSES_DIR=%CD%\classes
set LIB_DIR=%CD%\lib

if not exist "%CLASSES_DIR%" mkdir "%CLASSES_DIR%"

set CLASSPATH=%CLASSES_DIR%;%LIB_DIR%\mysql-connector-j-9.6.0.jar;%LIB_DIR%\jakarta.servlet-api-6.0.0.jar

javac -cp "%CLASSPATH%" -d "%CLASSES_DIR%" "%SRC_DIR%\com\signova\ConexionBD.java" "%SRC_DIR%\com\signova\PruebaConexion.java" "%SRC_DIR%\dao\UsuarioDAO.java" "%SRC_DIR%\modelo\Usuario.java"

if errorlevel 1 (
    echo.
    echo ========================================
    echo ERROR: No se pudo compilar el proyecto.
    echo ========================================
    pause
    exit /b 1
)

echo.
echo ========================================
echo Compilacion exitosa. Ejecutando prueba...
echo ========================================
echo.

java -cp "%CLASSPATH%" com.signova.PruebaConexion

echo.
echo ========================================
echo Prueba completada.
echo ========================================

pause