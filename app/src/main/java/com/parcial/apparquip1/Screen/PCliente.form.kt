package com.parcial.apparquip1.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.parcial.apparquip1.Datos.entidades.Cliente
import com.parcial.apparquip1.Presentacion.PCliente
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PCliente(navController: NavHostController, screenWidth: Dp, screenHeight: Dp) {
    val context = LocalContext.current
    val pCliente = PCliente(context)
    var isCreate by remember { mutableStateOf(true) }
    val focusManager = LocalFocusManager.current
    var id: Int by remember { mutableStateOf(0) }
    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var meta by remember { mutableStateOf("\n") }
    var caracteristicas by remember { mutableStateOf("\n") }
    var clientes: List<Cliente> by remember { mutableStateOf(pCliente.obtenerClientes()) }

    Scaffold(content = { paddingValues ->
        Box(
            modifier = Modifier
                .size(screenWidth, screenHeight)
                .fillMaxSize()
                .clickable(indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = {
                        focusManager.clearFocus()
                    })
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = screenHeight * 0.01f, vertical = screenHeight * 0.01f
                    ),
            ) {
                Box(
                    modifier = Modifier
                        .weight(0.6f)
                        .fillMaxWidth()
                ) {
                    // FORMULARIO DE CLIENTE
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = if (isCreate) "Crear Cliente" else "Editar Cliente",
                            style = MaterialTheme.typography.titleLarge,
                        )
                        TextField(modifier = Modifier.fillMaxWidth(),
                            value = nombre,
                            label = {
                                Text(
                                    text = "Nombre Completo",
                                    style = MaterialTheme.typography.titleSmall
                                )
                            },
                            textStyle = MaterialTheme.typography.titleMedium,
                            leadingIcon = {
                                Icon(Icons.Filled.Person, contentDescription = "Icono de persona")
                            },
                            singleLine = true,
                            onValueChange = { nombre = it },
                            shape = RoundedCornerShape(9.dp, 9.dp, 0.dp, 0.dp)
                        )
                        TextField(modifier = Modifier.fillMaxWidth(),
                            value = telefono,
                            label = {
                                Text(
                                    text = "Telefono", style = MaterialTheme.typography.titleSmall
                                )
                            },
                            textStyle = MaterialTheme.typography.titleMedium,
                            leadingIcon = {
                                Icon(Icons.Filled.Phone, contentDescription = "Icono de telefono")
                            },
                            singleLine = true,
                            onValueChange = { telefono = it },
                            shape = RoundedCornerShape(9.dp, 9.dp, 0.dp, 0.dp)
                        )
                        TextField(modifier = Modifier.fillMaxWidth(),
                            value = meta,
                            label = {
                                Text(
                                    text = "Meta Personal",
                                    style = MaterialTheme.typography.titleSmall
                                )
                            },
                            textStyle = MaterialTheme.typography.titleMedium,
                            leadingIcon = {
                                Icon(Icons.Filled.Star, contentDescription = "Icono de telefono")
                            },
                            maxLines = 2,
                            onValueChange = { meta = it },
                            shape = RoundedCornerShape(9.dp, 9.dp, 0.dp, 0.dp)
                        )
                        TextField(modifier = Modifier.fillMaxWidth(),
                            value = caracteristicas,
                            label = {
                                Text(
                                    text = "Peso, Altura y Edad",
                                    style = MaterialTheme.typography.titleSmall
                                )
                            },
                            textStyle = MaterialTheme.typography.titleMedium,
                            leadingIcon = {
                                Icon(Icons.Filled.Star, contentDescription = "Icono de telefono")
                            },
                            maxLines = 2,
                            onValueChange = { caracteristicas = it },
                            shape = RoundedCornerShape(9.dp, 9.dp, 0.dp, 0.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {

                            Button(
                                onClick = {
                                    if (isCreate) {
                                        pCliente.nombre = nombre
                                        pCliente.telefono = telefono
                                        pCliente.meta = meta
                                        pCliente.caracteristicas = caracteristicas
                                        pCliente.insertarCliente()
                                    } else {
                                        pCliente.id = id
                                        pCliente.nombre = nombre
                                        pCliente.telefono = telefono
                                        pCliente.meta = meta
                                        pCliente.caracteristicas = caracteristicas
                                            pCliente.actualizarCliente()
                                    }
                                    clientes = pCliente.obtenerClientes()
                                    focusManager.clearFocus()
                                    id = 0
                                    nombre = ""
                                    telefono = ""
                                    meta = "\n"
                                    caracteristicas = "\n"
                                },
                                shape = RoundedCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.primary,
                                )
                            ) {
                                Icon(
                                    Icons.Outlined.ThumbUp,
                                    contentDescription = "Salvar Datos",
                                    tint = MaterialTheme.colorScheme.secondary
                                )
                            }
                            Button(
                                onClick = {
                                    focusManager.clearFocus()
                                    isCreate = true
                                    nombre = ""
                                    telefono = ""
                                    meta = "\n"
                                    caracteristicas = "\n"
                                },
                                shape = RoundedCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.primary,
                                )
                            ) {
                                Icon(
                                    Icons.Filled.Add,
                                    contentDescription = "Cambiar a modalidad crear",
                                    tint = MaterialTheme.colorScheme.secondary
                                )
                            }
                            Button(
                                onClick = {
                                    focusManager.clearFocus()
                                    id = 0
                                    nombre = ""
                                    telefono = ""
                                    meta = "\n"
                                    caracteristicas = "\n"
                                },
                                shape = RoundedCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.primary,
                                )
                            ) {
                                Icon(
                                    Icons.Outlined.Delete,
                                    contentDescription = "Salvar Datos",
                                    tint = MaterialTheme.colorScheme.secondary
                                )
                            }
                            Button(
                                onClick = {
                                    navController.popBackStack()
                                },
                                shape = RoundedCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.primary,
                                )
                            ) {
                                Icon(
                                    Icons.Outlined.ArrowBack,
                                    contentDescription = "Volver Atras",
                                    tint = MaterialTheme.colorScheme.secondary
                                )
                            }

                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(0.4f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),

                        ) {
                        Text(
                            text = "Lista de Clientes",
                            style = MaterialTheme.typography.titleLarge,
                        )
                        if (clientes.isEmpty()) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "No hay clientes registrados",
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        } else {
                            LazyColumn() {
                                items(clientes.size) { index ->
                                    Column(
                                        modifier = Modifier.padding(bottom = screenHeight * 0.01f)
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column(
                                                modifier = Modifier.size(
                                                    screenWidth * 0.75f, screenHeight * 0.07f
                                                ), verticalArrangement = Arrangement.Center
                                            ) {
                                                Text(
                                                    text = clientes[index].nombre,
                                                    overflow = TextOverflow.Ellipsis,
                                                    maxLines = 1,
                                                    style = MaterialTheme.typography.titleMedium
                                                )
                                                Text(
                                                    text = clientes[index].telefono.toString(),
                                                    overflow = TextOverflow.Ellipsis,
                                                    maxLines = 1,
                                                    style = MaterialTheme.typography.titleMedium
                                                )
                                            }
                                            Row(
                                                modifier = Modifier.size(
                                                    screenWidth * 0.2f, screenHeight * 0.07f
                                                ),
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                IconButton(onClick = {
                                                    isCreate = false
                                                    id = clientes[index].id
                                                    nombre = clientes[index].nombre
                                                    telefono = clientes[index].telefono
                                                    meta = clientes[index].meta
                                                    caracteristicas =
                                                        clientes[index].caracteristicas
                                                }) {
                                                    Icon(
                                                        Icons.Filled.Edit,
                                                        contentDescription = "Editar Cliente",
                                                        tint = MaterialTheme.colorScheme.secondary
                                                    ) // Change the color here
                                                }
                                                IconButton(onClick = {
                                                    pCliente.id  = clientes[index].id
                                                    pCliente.eliminarCliente()
                                                    clientes = pCliente.obtenerClientes()
                                                }) {
                                                    Icon(
                                                        Icons.Filled.Clear,
                                                        contentDescription = "Eliminar Cliente",
                                                        tint = MaterialTheme.colorScheme.secondary
                                                    ) // Change the color here
                                                }
                                            }

                                        }
                                        Divider(
                                            color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.4f),
                                            thickness = 1.5.dp
                                        )
                                    }

                                }
                            }
                        }

                    }
                }
            }
        }
    })
}