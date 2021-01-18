from py.Graph import Graph
from py.Node import Node

class Add_Nodes:

    # Adding nodes based on miles
    def add_nodes(graph):
        graph.add_node("SpringField", {})
        graph.add_node("St. Louis", {'Quincy': 137, 'Mt. Vernon': 80, "Springfield": 98})
        graph.add_node("Quincy", {"Springfield": 111, "Peoria": 127})
        graph.add_node("Bloomington", {"Champaign": 50, "Peoria": 38, "Rockford": 133, "Chicago": 134, "Springfield": 64})
        graph.add_node("Champaign", {"Mt. Vernon": 147, "Springfield": 86, "Effingham": 78})
        graph.add_node("Mt. Vernon", {"Carbondale": 57, "Springfield": 143, "Effingham": 88})
        graph.add_node("Carbondale", {"St. Louis": 104, "Vandalia": 91})
        graph.add_node("Peoria", {"Kewanee": 49})
        graph.add_node("Rockford", {"Peoria": 135, "Chicago": 92, "Kewanee": 111})
        graph.add_node("Chicago", {"Champaign": 136})
        graph.add_node("Freeport", {"Peoria": 118, "Rockford": 27})
        graph.add_node("Kewanee", {"Springfield": 123})
        graph.add_node("Vandalia", {"Springfield": 76})
        graph.add_node("Chester", {"St. Louis": 66, "Carbondale": 38})
        graph.add_node("Effingham", {"Springfield": 88})
