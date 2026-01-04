@echo off
cls
echo Verificando ambiente Java...
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERRO] O Java nao foi encontrado no seu sistema.
    echo Por favor, instale o JRE ou JDK e tente novamente.
    pause
    exit
)

echo Iniciando Banco Yale...
java -jar untitled1.jar
pause
