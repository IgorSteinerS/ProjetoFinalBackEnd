# ProjetoFinalBackEnd

Este projeto foca no gerenciamento de notas e matérias para estudantes.

## Executando

Para executar o projeto:

1. Rode o arquivo `BackEndN3Application.java` localizado pelo caminho `BackEndN3/src/main/java/com/example/BackEndN3/BackEndN3Application.java`

## Tecnologias Utilizadas

* Spring Boot
* Spring Data JPA
* Validation
* H2 Database

## Recursos

1. Professor
2. Matéria
3. Avaliação

## Regras de Negócio


*Um professor deve possuir obrigatoriamente:
Um nome válido, não podendo ser vazio ou nulo.
O id do professor é gerado automaticamente como um UUID e não pode ser duplicado.
*Cada matéria deve obrigatoriamente:
Estar vinculada a um professor válido (regra de integridade referencial).
Possuir um nome válido, não podendo ser vazio ou nulo.
Não é permitido cadastrar uma matéria sem que o professor associado exista no sistema.
*Cada avaliação deve obrigatoriamente:
Estar vinculada a uma matéria existente no sistema.
Não é permitido cadastrar uma avaliação para uma matéria inexistente.

## Rotas


##Professores

#### `GET /professores`
Retorna todos os professores cadastrados no sistema.

Resposta:
````json
[
  {
    "id": "UUID",
    "nome": "Nome do Professor"
  }
]
````


#### `GET /professores/{id}`
Retorna um professor específico pelo ID.

Resposta:
````json
{
  "id": "UUID",
  "nome": "Nome do Professor"
}
````

Respostas de erro:
* `404` - Professor não encontrado;

#### `POST /professores`

Cadastra um novo professor.

Corpo da Requisição:
````json
{
  "nome": "Nome do Professor"
}
````

Corpo da Resposta:
````json
{
  "id": "UUID",
  "nome": "Nome do Professor"
}
````
Respostas de erro:

* `400` - nome vazio.
* `500` - nome já existe.

#### `PUT /professores/{id}`

Atualiza um professor existente pelo ID.

Corpo da Requisição:
````json
{
  "nome": "Nome do Professor Atualizado"
}
````

Corpo da Resposta:
````json
{
  "id": "UUID",
  "nome": "Nome do Professor Atualizado"
}
````

Respostas de erro:
* `400` - `id` inválido;
* `400` - nome vazio;
* `404` - Professor não encontrada;

#### `DELETE /professores/{id}`

Deleta um professor específico pelo ID.

Respostas de erro:
* `404` - professor não encontrado;
* `500` - professor ainda está cadastrada em uma matéria.

### Matérias

#### `GET /materias`
Retorna todas as matérias cadastradas no sistema.

Resposta:
````json
[
  {
    "id": "UUID",
    "nome": "Nome da Matéria",
    "professor": {
      "id": "UUID",
      "nome": "Nome do Professor"
    }
  }
]
````


#### `GET /materias/{id}`
Retorna uma matéria específica pelo ID.

Resposta:
````json
{
  "id": "UUID",
  "nome": "Nome da Matéria",
  "professor": {
    "id": "UUID",
    "nome": "Nome do Professor"
  }
}
````

Respostas de erro:
* `404` - Matéria não encontrada;

#### `POST /materias`

Cadastra uma nova matéria.

Corpo da Requisição:
````json
{
  "nome": "Nome da Matéria",
  "professorId": "UUID"
}
````

Corpo da Resposta:
````json
{
  "id": "UUID",
  "nome": "Nome da Matéria",
  "professor": {
    "id": "UUID",
    "nome": "Nome do Professor"
  }
}
````
Respostas de erro:

* `400` - nome vazio.
* `400` - professorId vazio.
* `400` - professorId Invalido.
* `500` - nome já existe.

#### `PUT /materias/{id}`

Atualiza uma matéria existente pelo ID.

Corpo da Requisição:
````json
{
  "nome": "Nome da Matéria Atualizada",
  "professorId": "UUID Atualizado"
}
````

Corpo da Resposta:
````json
{
  "id": "UUID",
  "nome": "Nome da Matéria Atualizada",
  "professor": {
    "id": "UUID Atualizado",
    "nome": "Nome do Professor Atualizado"
  }
}
````

Respostas de erro:
* `400` - nome vazio.
* `400` - professorId vazio.
* `400` - professorId Invalido.
* `404` - Matéria não encontrada;

#### `DELETE /materias/{id}`

Deleta uma matéria específica pelo ID.

Respostas de erro:
* `404` - Matéria não encontrada;
* `500` - Matéria ainda está cadastrada em um professor;

##Avaliações

#### `GET /avaliacoes`
Retorna todas as avaliações cadastradas no sistema.

Resposta:
````json
[
  {
    "id": "UUID",
    "nome": "Nome da Avaliação",
    "peso": 10,
    "notaFinal": 8,
    "materia": {
      "id": "UUID",
      "nome": "Nome da Matéria",
      "professor": {
        "id": "UUID",
        "nome": "Nome do Professor"
      }
    }
  }
]
````


#### `GET /avaliacoes/{id}`
Retorna uma avaliação específica pelo ID.

Resposta:
````json
[
  {
    "id": "UUID",
    "nome": "Nome da Avaliação",
    "peso": 10,
    "notaFinal": 8,
    "materia": {
      "id": "UUID",
      "nome": "Nome da Matéria",
      "professor": {
        "id": "UUID",
        "nome": "Nome do Professor"
      }
    }
  }
]
````

Respostas de erro:
* `404` - Avaliação não encontrado;

#### `POST /avaliacoes`

Cadastra uma nova avaliação.

Corpo da Requisição:
````json
{
  "nome": "Nome da Avaliação",
  "peso": 10,
  "notaFinal": 8,
  "materiaId": "UUID"
}
````

Corpo da Resposta:
````json
{
  "id": "UUID",
  "nome": "Nome da Avaliação",
  "peso": 10,
  "notaFinal": 8,
  "materia": {
    "id": "UUID",
    "nome": "Nome da Matéria",
    "professor": {
      "id": "UUID",
      "nome": "Nome do Professor"
    }
  }
}
````
Respostas de erro:

* `400` - nome vazio.
* `400` - peso vazio.
* `400` - peso negativo.
* `400` - notaFinal vazia.
* `400` - notaFinal negativa.
* `500` - nome já existe.

#### `PUT /avaliacoes/{id}`

Atualiza uma atualização existente pelo ID.

Corpo da Requisição:
````json
{
  "nome": "Nome da Avaliação Atualizada",
  "peso": Integer Atualizado,
  "notaFinal": Integer Atualizado,
  "materiaId": "UUID Atualizado"
}
````

Corpo da Resposta:
````json
{
  "id": "UUID",
  "nome": "Nome da Avaliação Atualizada",
  "peso": Integer Atualizado,
  "notaFinal": Integer Atualizado,
  "materia": {
    "id": "UUID Atualizado",
    "nome": "Nome da Matéria Atualizado",
    "professor": {
      "id": "UUID Atualizado",
      "nome": "Nome do Professor Atualizado"
    }
  }
}

````

Respostas de erro:
* `400` - nome vazio.
* `400` - peso vazio.
* `400` - peso negativo.
* `400` - notaFinal vazia.
* `400` - notaFinal negativa.
* `400` - materiaId vazio.
* `400` - materiaId Invalido.
* `404` - Avaliação não encontrada;
* `500` - nome já existe.



#### `DELETE /avaliacoes/{id}`

Deleta uma avaliação específica pelo ID.

Respostas de erro:
* `404` - avaliação não encontrada;






