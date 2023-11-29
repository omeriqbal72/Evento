package com.example.evento_1.ui.theme.Home

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.evento_1.R


fun getEvents (context : Context) : List<EventInfo> {
    val eventList = mutableListOf<EventInfo>()
//    val painter: Painter = painterResource1(id = R.drawable.eventone)
//    val paintertwo :Painter = painterResource1(id = R.drawable.eventtwo)


    eventList.add(EventInfo("Music fest" , "There is an amazing event going to take place at your doorstep with free entrance." , "Hello" ))
    eventList.add(EventInfo("Concert" , "There is an amazing event going to take place at your doorstep with free entrance." , "Hello" ))
    eventList.add(EventInfo("Educational Event" , "There is an amazing event going to take place at your doorstep with free entrance." , "Hello" ))
    eventList.add(EventInfo("The Qawali" , "There is an amazing event going to take place at your doorstep with free entrance." , "Hello" ))


    return eventList
}

@Composable
fun EventCard (event :EventInfo){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color.Black)
    ){
        
        Row (

            horizontalArrangement = Arrangement.spacedBy(6.dp),


        ){
            Image(
                modifier = Modifier.width(150.dp),
                painter = painterResource(id = R.drawable.eventone),
                contentDescription = null ,

            )
            Column {
                Text(
                    text = event.name,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(text = event.description,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
        }
        
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ){
            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null , tint = Color.White)
            Icon(imageVector = Icons.Filled.MoreVert , contentDescription = null , tint = Color.White)
        }
    }

}

@Composable
fun DisplayEvents(events: List<EventInfo>){
    Column (

        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){
        Text(text="hello This home page ")

        Text(text = "")
        LazyColumn(){
            items(events){
                    event -> EventCard(event = event)
            }
        }
    }
}

@Composable
fun Home (){
    val context = LocalContext.current
    val events = remember { getEvents(context) }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(10.dp)// Set the background color of the main content
    ) {
        Text(
            text = "Events", fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            color = Color.White
        )

        DisplayEvents(events = events)
    }
}

@Composable
fun HomePage () = Home()