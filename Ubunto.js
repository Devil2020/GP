var spawn = require("child_process").spawn;
const express = require('express'),
http = require('http'),
app = express(),
server = http.createServer(app),
io = require('socket.io').listen(server);
app.get('/', function(req, res) {

res.send('Chat Server is running on port 3000')
});
io.on('connection',function (socket) {

        socket.on('DataFromUser', function (UserProblem) {
        //Call on code that execute the Python Code
                var path='E:\\GP\\Pre-Processing.py'
                //python File , User Input
                var pythonProcess = spawn('python', [path, "ABCD"]);
                pythonProcess.stdout.on('data', function (data) {
                        // Do something with the data returned from python script
                        var returnData = data.toString('utf8');
                        console.log(returnData)
                        socket.broadcast.emit("DataFromMOdel",returnData)
                    })       
        })
        })

server.listen(3000,function(){
console.log('Node app is running on port 3000')

})
 
app.listen(3000)