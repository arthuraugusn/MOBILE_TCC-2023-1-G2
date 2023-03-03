package br.senai.sp.jandira.vanbora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.vanbora.components.HeaderSelectDriverComplement
import br.senai.sp.jandira.vanbora.ui.theme.VanboraTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class UserActivityComplements : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VanboraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val systemUi = rememberSystemUiController()
                    SideEffect {
                        systemUi.setStatusBarColor(color = Color(255, 255, 255, 0), darkIcons = true)
                    }
                    DadosAdicionaisUser()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DadosAdicionaisUser() {

    val context = LocalContext.current

    val selectActivy by remember {
        mutableStateOf(SelectActivity::class.java)
    }

    //==================================

    var rgState by rememberSaveable() {
        mutableStateOf("")
    }

    var cpfState by rememberSaveable() {
        mutableStateOf("")
    }

    var cepState by rememberSaveable() {
        mutableStateOf("")
    }

    var telefoneState by rememberSaveable() {
        mutableStateOf("")
    }

    var dataNascimentoState by rememberSaveable() {
        mutableStateOf("")
    }

    var isRgError by remember() {
        mutableStateOf(false)
    }

    var isCpfError by remember() {
        mutableStateOf(false)
    }

    var isCepError by remember() {
        mutableStateOf(false)
    }

    var isTelefoneError by remember() {
        mutableStateOf(false)
    }

    var isDataNascimentoError by remember() {
        mutableStateOf(false)
    }


    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background2),
                contentScale = ContentScale.Crop
            ).verticalScroll(scrollState),
        verticalArrangement = Arrangement.SpaceAround
    ) {

        //Header
        HeaderSelectDriverComplement(
            context = context,
            componentActivity = selectActivy.newInstance()
        )

        //Main
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.addphoto),
                contentDescription = "add foto",
                modifier = Modifier
                    .width(300.dp)
                    .height(100.dp),
            )

            //RG
            OutlinedTextField(
                value = rgState, onValueChange = {
                    rgState = it

                    if (it == "" || it == null) {
                        isRgError
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 52.dp, end = 52.dp),
                label = {
                    Text(
                        text = stringResource(id = R.string.rg),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = Color.Black,
                        )
                    )
                },
                trailingIcon = {
                    if (isRgError) Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = ""
                    )
                },
                isError = isRgError,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0, 0, 0, 255),
                    unfocusedBorderColor = Color(0, 0, 0, 255)
                )
            )
            if (isRgError) {
                Text(
                    text = stringResource(id = R.string.rg_error),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 52.dp),
                    color = Color.Red,
                    fontSize = 15.sp,
                    textAlign = TextAlign.End
                )
            }

            //CPF
            OutlinedTextField(
                value = cpfState, onValueChange = {
                    cpfState = it

                    if (it == "" || it == null) {
                        isCpfError
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 52.dp, end = 52.dp),
                label = {
                    Text(
                        text = stringResource(id = R.string.cpf),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = Color.Black,
                        )
                    )
                },
                trailingIcon = {
                    if (isCpfError) Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = ""
                    )
                },
                isError = isCpfError,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0, 0, 0, 255),
                    unfocusedBorderColor = Color(0, 0, 0, 255)
                )
            )
            if (isCpfError) {
                Text(
                    text = stringResource(id = R.string.cpf_error),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 52.dp),
                    color = Color.Red,
                    fontSize = 15.sp,
                    textAlign = TextAlign.End
                )
            }

            //CEP
            OutlinedTextField(
                value = cepState, onValueChange = {
                    cepState = it

                    if (it == "" || it == null) {
                        isCepError
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 52.dp, end = 52.dp),
                label = {
                    Text(
                        text = stringResource(id = R.string.cep),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = Color.Black,
                        )
                    )
                },
                trailingIcon = {
                    if (isCepError) Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = ""
                    )
                },
                isError = isCepError,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0, 0, 0, 255),
                    unfocusedBorderColor = Color(0, 0, 0, 255)
                )
            )
            if (isCepError) {
                Text(
                    text = stringResource(id = R.string.cep_error),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 52.dp),
                    color = Color.Red,
                    fontSize = 15.sp,
                    textAlign = TextAlign.End
                )
            }

            //TELEFONE
            OutlinedTextField(
                value = telefoneState, onValueChange = {
                    telefoneState = it

                    if (it == "" || it == null) {
                        isTelefoneError
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 52.dp, end = 52.dp),
                label = {
                    Text(
                        text = stringResource(id = R.string.telefone),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = Color.Black,
                        )
                    )
                },
                trailingIcon = {
                    if (isTelefoneError) Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = ""
                    )
                },
                isError = isTelefoneError,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0, 0, 0, 255),
                    unfocusedBorderColor = Color(0, 0, 0, 255)
                )
            )
            if (isTelefoneError) {
                Text(
                    text = stringResource(id = R.string.telefone_error),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 52.dp),
                    color = Color.Red,
                    fontSize = 15.sp,
                    textAlign = TextAlign.End
                )
            }

            //DATA NASCIMENTO
            OutlinedTextField(
                value = dataNascimentoState, onValueChange = {
                    dataNascimentoState = it

                    if (it == "" || it == null) {
                        isDataNascimentoError
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 52.dp, end = 52.dp),
                label = {
                    Text(
                        text = stringResource(id = R.string.data_nascimento),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = Color.Black,
                        )
                    )
                },
                trailingIcon = {
                    if (isDataNascimentoError) Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = ""
                    )
                },
                isError = isDataNascimentoError,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0, 0, 0, 255),
                    unfocusedBorderColor = Color(0, 0, 0, 255)
                )
            )
            if (isDataNascimentoError) {
                Text(
                    text = stringResource(id = R.string.data_nascimento_error),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 52.dp),
                    color = Color.Red,
                    fontSize = 15.sp,
                    textAlign = TextAlign.End
                )
            }

        }

        //Footer
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    isRgError = rgState.isEmpty()
                    isCpfError = cpfState.isEmpty()
                    isCepError = cepState.isEmpty()
                    isTelefoneError = telefoneState.isEmpty()
                    isDataNascimentoError = dataNascimentoState.isEmpty()

                },
                colors = ButtonDefaults.buttonColors(Color(250, 210, 69, 255))

            ) {
                Text(
                    text = stringResource(id = R.string.next)
                )
            }
        }
    }
}

