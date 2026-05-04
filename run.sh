#!/bin/bash

# Script tu dong hoa kiem tra du an MathProject
echo "-------------------------------------------------------"
echo "Dang bat dau kiem tra toan bo du an (Bai 3 - 9)..."
echo "-------------------------------------------------------"

# 1. Bien dich va kiem tra Checkstyle + JaCoCo Coverage
echo "📦 [Buoc 1/3] Dang bien dich va kiem tra tieu chuan ma nguon..."
mvn clean verify

if [ $? -ne 0 ]; then
    echo "❌ Loi: Build that bai. Vui long kiem tra Checkstyle hoac Coverage!"
    exit 1
fi

# 2. Dong goi JAR thuc thi
echo "🛠️ [Buoc 2/3] Dang dong goi san pham JAR..."
mvn package -DskipTests

# 3. Chay ung dung va kiem tra Log
echo "🖥️ [Buoc 3/3] Dang thuc thi va kiem tra Logging..."
JAR_FILE=$(find target -name "*.jar" ! -name "*-sources.jar")
java -jar "$JAR_FILE"

if [ -f "logs/app.log" ]; then
    echo "✅ Ket qua: Log da duoc ghi tai logs/app.log"
    tail -n 2 logs/app.log
else
    echo "⚠️ Canh bao: Khong tim thay tep tin log!"
fi
