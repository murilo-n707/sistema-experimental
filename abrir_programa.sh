#!/bin/bash
clear
echo "Verificando ambiente Java..."
if ! command -v java &> /dev/null
then
    echo "[ERRO] O Java nao foi encontrado no seu sistema."
    echo "Por favor, instale o JRE ou JDK e tente novamente."
    read -n 1 -s -p "Pressione qualquer tecla para continuar..."
    exit
fi

echo "Iniciando Banco Yale..."
java -jar untitled1.jar
read -n 1 -s -p "Pressione qualquer tecla para continuar..."
