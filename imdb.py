#import for using the omdb api 
import json, requests
#import itemgetter for sorting the episodes list of dict by rating
from operator import itemgetter

def searchMovie(movieName):
    url = 'http://www.omdbapi.com/?apikey=d33a8bd8&s='+movieName
    resp = requests.get(url=url)
    data = json.loads(resp.text)
    search = data['Search']
    #print data
    for i in search:
        
        u = 'http://www.omdbapi.com/?apikey=d33a8bd8&t='+i['Title']
        resp1 = requests.get(url=u)
        data1 = json.loads(resp1.text)
        
        if data1['Response']=="True": 
            if len(data1['Ratings'])>0:
                print i['Title'],data1['Ratings'][0]['Value']
            else:
                print i['Title'],'[Rating N/A]'
        else:
            continue




def getSeasons(showName, season):

    url = 'http://www.omdbapi.com/?apikey=d33a8bd8&t='+showName+'&Season='+season
    episodes = []
    resp = requests.get(url=url)
    data = json.loads(resp.text)
    for i in data['Episodes']:
        episodes.append({'Episode': i['Episode'], 'Rating': i['imdbRating'], 'Title': i['Title']})
        #print i['Title'],i['imdbRating']
    #newList = []
    episodes = sorted(episodes, key=itemgetter('Rating'),reverse=True) 
    for k in episodes:
        print k['Episode'],k['Title'],k['Rating']
    
def allSeasons(showName):
    url = 'http://www.omdbapi.com/?apikey=d33a8bd8&t='+showName
    episodes = []
    resp = requests.get(url=url)
    data = json.loads(resp.text)
    totalSeasons = int(data['totalSeasons'])
    #print "Season 1"
    for j in range(1,totalSeasons+1,1):
        
        print "\n"+"Season "+ str(j) +"\n"
        getSeasons(showName,str(j)) 
    

#searchMovie('rome')
#getSeasons('Game of thrones','6')
#allSeasons('Game of thrones')
allSeasons('How i met your mother')
#getSeasons('Shark Tank','1')
