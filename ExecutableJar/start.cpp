#pragma comment(linker,"/subsystem:\"Windows\" /entry:\"mainCRTStartup\"")
#include <stdio.h>
#include <stdlib.h>
int main(){
    system(".\\start.vbs");
}