const boxes= document.querySelectorAll(".box");
const mole= document.querySelectorAll(".mole");
const restart= document.getElementById("restrt");
const timec=document.getElementById("time");
const scorec= document.getElementById("score");
let score=0;
let currbox=0;
let islocked= false;
let currt=10;

function showmole(){
   boxes.forEach((box)=>{box.classList.remove("mole"); });
    islocked=false;
    let randombox=boxes[Math.floor(Math.random()*9)];
    randombox.classList.add("mole");
    currbox= randombox.id;
}

// showmole();
 function start(){
    score=0;
    currt=10;

     molet = setInterval(showmole,1000);
     timet=setInterval(cttime,1000);
     
     timec.innerText=currt;
     scorec.innerText=score;
 }
 start();
 boxes.forEach((box) =>{
     box.addEventListener("click",()=> {if(box.id==currbox){
         if (islocked) return;
         score++;
         scorec.innerText=score;
            box.classList.remove("mole");
            islocked=true;
 
     }});
 });
 function cttime(){
     currt--;
     timec.innerText=currt; 
     if(currt==0)
     {
         clearInterval(timet);
         clearInterval(molet);
         alert("GAME OVER\n Your Score is - "+ score);
     }
 }
 function restartGame(){
    clearInterval(timet);
    clearInterval(molet);
    start();
 }
 restart.addEventListener("click",restartGame );
 