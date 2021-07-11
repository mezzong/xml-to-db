<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>${msg}</title>
    <style type="text/css">
        #code {
            display: inline-block;
            text-align: left;
        }
    </style>
</head>
<body>
<hr/>

<div class="container ">
    <div class="row h-100 justify-content-center align-items-center">
        <div class="card mb-2 shadow-sm text-left">
            <div class="card-header">
                <h1 class="my-0 font-weight-normal">Select xml file</h1>
            </div>
            <div class="card-body">
                <ul class="list-unstyled mt-3 mb-4">
                    <li><p>Select your xml file for insert into table Organizations</p></li>
                    <li><h4>Example xml file</h4></li>
                    <li><pre id="code"><code align="left">
&lt;?xml version="1.0" encoding="UTF-8" ?&gt;
    &lt;/organizations&gt;
    &lt;organization&gt;
    &lt;id&gt;203&lt;/id&gt;
    &lt;name&gt;Company&lt;/name&gt;
    &lt;/organization&gt;
&lt;/organizations&gt;
                    </code>
                </pre></li>
                </ul>
                <form class="my-auto" action="upload" method="post" enctype="multipart/form-data">
                    <div class="custom-file">
                        <input name="file" type="file" id="validatedCustomFile" required>
                    </div>
                    <input type="submit" value="Upload" class="btn btn-lg btn-block btn-primary">
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>