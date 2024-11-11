package com.example.applistacompra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applistacompra.data.Datasource
import com.example.applistacompra.model.Lista
import com.example.applistacompra.ui.theme.AppListaCompraTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppListaCompraTheme {
                var listaActualizable = Datasource().loadLista().toMutableList()
                var labdaActualizaLista = { listaActualizable=listaActualizable.toMutableList() }
                ListaApp(listaActualizable,labdaActualizaLista, modifier = Modifier)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//-AR: El scaffold se empieza a definir aquí, ya no arriba
fun ListaApp(listaActualizable : MutableList<Lista>,labdaActualizaLista: () -> Unit, modifier : Modifier){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Lista de la compra")}
            )
        }
    ) {
        //BodyContent(listaInicial = Datasource().loadLista(),modifier = modifier.padding(it))
        BodyContent(listaInicial = listaActualizable,labdaActualizaLista ,modifier = modifier.padding(it))
    }
}

@Composable
fun BodyContent (listaInicial : MutableList<Lista>,labdaActualizaLista: () -> Unit,modifier: Modifier){
    var concepto by remember { mutableStateOf("") }
    var cantidad : Int by remember { mutableIntStateOf(1) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        //-AR: Ojo, si lo centro vertical_ arriba, se pone bajo la topbar
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        TextField(
            label = { Text("Concepto") },
            value = concepto,
            onValueChange = { nuevoTexto:String -> concepto = nuevoTexto },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.padding(bottom=12.dp)

        )

        TextField(
            label = { Text("Cantidad") },
            value = cantidad.toString(),
            onValueChange = { nuevoTexto:String ->
                if (nuevoTexto.toIntOrNull() != null){
                    cantidad = nuevoTexto.toInt()
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.padding(bottom=12.dp)

        )

        Button(
            onClick = {
                val nuevoItem = Lista(R.string.cosa1,R.integer.cosa5int)
                listaInicial.add(nuevoItem)
                //listaInicial = listaInicial.toMutableList()
                labdaActualizaLista()
                //-AR:Esto no funciona, intuyo que necesita elevación
            },
            modifier = Modifier.padding(bottom=12.dp)
        ){
            Text("Guardar")
        }

        LazyColumn(modifier = Modifier) {
            items(listaInicial) { Lista ->
                    ListaItem(
                        concepto = stringResource(Lista.stringResourceId),
                        cantidad = integerResource(Lista.integerResourceId),
                        modifier = Modifier,
                    )
            }
        }


    }
}

@Composable
fun ListaItem(concepto : String, cantidad: Int, modifier: Modifier = Modifier){
    Card(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(concepto)
            Spacer(modifier = Modifier.weight(1f))
            Text(cantidad.toString())
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    //-AR: introduzco la info de eliminar info

                })
                {
                    Text("Borrar")
                }


        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var listaActualizable = Datasource().loadLista().toMutableList()
    var labdaActualizaLista = { listaActualizable=listaActualizable.toMutableList() }
    ListaApp(listaActualizable,labdaActualizaLista, modifier = Modifier)

}